package graphtea.extensions.reports.boundcheck.forall.filters;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by rostam on 20.11.15.
 */
public class DivideBigData extends JFrame {
    public static void main(String[] args) throws IOException {
        int size = 1715024;
        int part = 10;
        //Create a file chooser
        final JFileChooser fc = new JFileChooser();

        int returnVal = fc.showOpenDialog(new DivideBigData());

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            Scanner sc = new Scanner(file);
            for(int i=0;i < part;i++) {
                String tmp = file.getAbsolutePath();
                tmp = tmp.substring(0,tmp.lastIndexOf("/"));
                String tmp2 = file.getName().substring(0,file.getName().lastIndexOf("."));
                tmp = tmp + tmp2 + +(i+1) + ".g6";
                FileWriter fw = new FileWriter(new File(tmp));
                System.out.println(tmp);
//                for(int j=0;j < size;j++) {
//                    if(sc.hasNext()) {
//                        fw.write(sc.nextLine());
//                    }
//                }
                fw.close();
            }

        }
    }
}