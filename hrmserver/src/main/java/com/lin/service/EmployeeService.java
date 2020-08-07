package com.lin.service;

import com.lin.dao.EmployeeDao;
import com.lin.entity.Employee;
import com.lin.entity.MailConstants;
import com.lin.entity.MailSendLog;
import com.lin.entity.RespPageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    MailSendLogService mailSendLogService;
    public final static Logger logger= LoggerFactory.getLogger(EmployeeService.class);
    SimpleDateFormat yearFormat=new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    DecimalFormat decimalFormat = new DecimalFormat("##.00");
    public RespPageBean getEmployeeByPage(Integer page, Integer size, Employee employee, Date[]beginDateScope){
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Employee> data = employeeDao.getEmployeeByPage(page, size, employee, beginDateScope);
        Long total = employeeDao.getTotal(employee, beginDateScope);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Integer addEmp(Employee employee) {
        Date beginContract = employee.getBeginContract();
        Date endContract = employee.getEndContract();
        double month=(Double.parseDouble(yearFormat.format(endContract))-Double.parseDouble(yearFormat.format(beginContract)))*12+(Double.parseDouble(monthFormat.format(endContract))- Double.parseDouble(monthFormat.format(beginContract)));
        employee.setContractTerm(Double.parseDouble(decimalFormat.format(month / 12)));
        int result = employeeDao.insertSelective(employee);
        if (result == 1) {
            Employee emp=employeeDao.getEmployeeById(employee.getId());
            String msgId = UUID.randomUUID().toString();
            MailSendLog mailSendLog = new MailSendLog();
            mailSendLog.setMsgId(msgId);
            mailSendLog.setCreateTime(new Date());
            mailSendLog.setExchange(MailConstants.MAIL_EXCHANGE_NAME);
            mailSendLog.setRouteKey(MailConstants.MAIL_ROUTING_KEY_NAME);
            mailSendLog.setEmpId(emp.getId());
            mailSendLog.setTryTime(new Date(System.currentTimeMillis()+1000*60*MailConstants.MSG_TIMEOUT));
            mailSendLogService.insert(mailSendLog);
            rabbitTemplate.convertAndSend(MailConstants.MAIL_EXCHANGE_NAME,MailConstants.MAIL_ROUTING_KEY_NAME,emp,new CorrelationData(msgId));
        }
        return result;
    }

    public Integer maxWorkID() {
        return employeeDao.maxWorkID();
    }

    public Integer deleteEmpByEid(Integer id) {
        return employeeDao.deleteById(id);
    }

    public Integer updateEmp(Employee employee) {
        return employeeDao.updateByPrimaryKeySelective(employee);
    }

    public Integer addEmps(List<Employee> list) {
        return employeeDao.addEmps(list);
    }

    public RespPageBean getEmployeeByPageWithSalary(Integer page, Integer size) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Employee> list = employeeDao.getEmployeeByPageWithSalary(page, size);
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(list);
        respPageBean.setTotal(employeeDao.getTotal(null, null));
        return respPageBean;
    }

    public Integer updateEmployeeSalaryById(Integer eid, Integer sid) {
        return employeeDao.updateEmployeeSalaryById(eid, sid);
    }

    public Employee getEmployeeById(Integer empId) {
        return employeeDao.getEmployeeById(empId);
    }
}
