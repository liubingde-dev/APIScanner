import com.lbd.analyst.IJavaCodeAnalyst;
import com.lbd.analyst.JavaCodeAnalyst;
import com.lbd.analyst.model.ClassModel;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class JavaCodeAnalystTest {
    private static String CODE_PATH="/home/liubingde/Downloads/litemall-master/litemall-master/litemall-wx-api/src";
    @Test
    public void testGetClassListHasApi(){
        IJavaCodeAnalyst javaCodeAnalyst=new JavaCodeAnalyst(new File(CODE_PATH));

        List<ClassModel> classModelList=javaCodeAnalyst.getClassListHasApi();

        for(ClassModel classModel:classModelList){
            System.out.println(classModel.getFullyQualifiedName());
        }
    }
}
