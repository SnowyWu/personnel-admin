import com.ruoyi.RuoYiApplication;
import com.ruoyi.employee.domain.AccountAndName;
import com.ruoyi.employee.domain.EmployeeAccount;
import com.ruoyi.employee.mapper.EmployeeAccountMapper;
import com.ruoyi.recruitment.domain.InterviewEvaluation;
import com.ruoyi.recruitment.service.IInterviewEvaluationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RuoYiApplication.class )
public class AppText {

    @Autowired
   private EmployeeAccountMapper employeeAccountMapper;

    @Autowired
    private IInterviewEvaluationService interviewEvaluationService;
    @Test
    public void text1(){
     interviewEvaluationService.insertInterviewEvaluation(
             new InterviewEvaluation(
                     null,
                     "张三",
                     null,
                     null,
                     (long)2,
                     null
             )
     );
    }
}
