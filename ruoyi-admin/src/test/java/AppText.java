import com.ruoyi.employee.domain.AccountAndName;
import com.ruoyi.employee.domain.EmployeeAccount;
import com.ruoyi.employee.mapper.EmployeeAccountMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AppText {

    @Autowired
    private EmployeeAccountMapper employeeAccountMapper;
    @Test
    public void text1(){
        List<AccountAndName> accountAndNames = employeeAccountMapper.selectEmployeeAndNameList(new EmployeeAccount());
    }
}
