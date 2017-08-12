import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final Pattern directoriesPattern = Pattern.compile(".*\\\\");

    public static void main(String[] args) throws IOException {
        System.out.println(Charset.forName("SJIS"));
        for (Ykc.FileEntry e: Ykc.fromFile("data03.ykc").header().entries()) {
            String filename = e.filename().trim()/*.replace('\\', '/')*/;
            System.out.println(filename);
            File f = new File("out/"+filename);
            mkDirs(f.getPath());

            try (FileOutputStream fs = new FileOutputStream(f)) {
                fs.write(e.body());
                fs.flush();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    private static void mkDirs(String s) {
        Matcher m = directoriesPattern.matcher(s);
        if (!m.find()) {
            System.out.println();

            return;
        }
        File f = new File(m.group());
        f.mkdirs();
    }
}
