import com.lbd.analyst.model.type.DecimalType;
import com.lbd.analyst.model.type.IntergerType;
import com.lbd.analyst.model.type.ObjectType;
import com.lbd.analyst.model.type.StringType;
import org.junit.Test;

public class TypeTest {
    @Test
    public void testGetDefaultValue(){
        ObjectType objectType=new ObjectType();
        objectType.addField("testString",new StringType());
        objectType.addField("testInterger",new IntergerType());
        objectType.addField("testDecimal",new DecimalType());
        ObjectType subObjectType=new ObjectType();
        subObjectType.addField("testString",new StringType());
        subObjectType.addField("testInterger",new IntergerType());
        objectType.addField("testObject",subObjectType);
        System.out.println(objectType.getDefaultValue());
    }

}
