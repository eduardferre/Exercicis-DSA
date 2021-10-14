import org.junit.Assert;
import org.junit.Test;

public class I18NManagerTest{

    @Test
    public void testGetText() throws Exception {
        String msg1 = I18NManager.getInstance().getText("l1","ca");
        //Repeteixo el procés per comprovar que realment ara hi accedeix a través de la caché.
        String msg2 = I18NManager.getInstance().getText("l1","ca");
        Assert.assertEquals("hola", msg1);
    }
}
