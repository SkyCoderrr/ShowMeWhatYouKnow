import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
/**
 * @author Sebastian Ren
 * Sample Program Comiler
 */
public class MyCompiler
{
    private String code;
    public MyCompiler(String s)
    {
        this.code=s;

    }

    public int naive_compiler() throws Exception
    {
        File file =new File("program.java");
        if(!file.exists())
        {
            try
            {
                file.createNewFile();
            } catch (IOException e1)
            {
                e1.printStackTrace();
            }
        }
        System.out.println(file.getAbsolutePath());
        OutputStream os = new FileOutputStream(file);
        os.write(code.getBytes(),0,code.length());
        os.flush();
        os.close();

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null,null,null,"program.java");
        System.out.println(result==0?"Compile Success":"Compile Failed");
        return result;
    }

    public BufferedReader run(int result) throws IOException
    {
        if (result!=0)
        {
            return null;
        }else
        {
            Runtime rt = Runtime.getRuntime();
            Process pro = rt.exec("java program");
            InputStream in = pro.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            return reader;
        }
    }

}
