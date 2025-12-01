/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cl.SaveData.Consola.FUN;

import Cl.SaveData.Consola.Conf.Confi;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.JFileChooser;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author march
 */
public class Directorio {
    static File[] oldListRoot = File.listRoots();
    
    public void CopiarArchivos(String sourceFile, String destinationFile) {

            try {

                File inFile = new File(sourceFile);
                File outFile = new File(destinationFile);

                FileInputStream in = new FileInputStream(inFile);
                FileOutputStream out = new FileOutputStream(outFile);

                byte[] buffer = new byte[1024];
                int c;

                while ((c = in.read(buffer)) != -1) {
                    out.write(buffer, 0, c);
                }

                out.flush();
                in.close();
                out.close();

            } catch (IOException e) {
                System.out.println("Hubo un error de entrada/salida!!!");
//            Log.e(TAG, "Hubo un error de entrada/salida!!!");
            }
        }
    
    public static String buscarDirectrorio(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.showOpenDialog(null);
//        System.out.println(fileChooser.getSelectedFile());
        //String url = "c:/Users/march/Desktop/";
        String url = fileChooser.getSelectedFile().toString();
        //url=url.replace('\\', '/');
        return url;
    }
    
    public static String crearDirec(String url,String carpeta){
        String resp="";
        File directorio = new File(url +"/"+ carpeta );
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                resp=directorio.toString();
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
        return resp;
    }
    
    public static boolean rutaExiste(Path ruta) {
        Path path = ruta;
        return Files.exists(path);
    }
    
    public static boolean carpetaTieneContenido(Path ruta) throws IOException {
        try (var stream = Files.list(ruta)) {
            return stream.findFirst().isPresent();
        }catch (IOException e) {
            return false;
        }
    }
    
    public static void copiarDirectorio(Path origenPath, Path destinoPath) throws IOException {
        Files.walkFileTree(origenPath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                Path destinoDir = destinoPath.resolve(origenPath.relativize(dir));
                Files.createDirectories(destinoDir);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.copy(file, destinoPath.resolve(origenPath.relativize(file)), StandardCopyOption.REPLACE_EXISTING);
                return FileVisitResult.CONTINUE;
            }
        });
    }
    
    public static void waitForNotifying() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (File.listRoots().length > oldListRoot.length) {
                        System.out.println("new drive detected");
                        oldListRoot = File.listRoots();
                        System.out.println("drive "+oldListRoot[oldListRoot.length-1]+" detected");
                    } else if (File.listRoots().length < oldListRoot.length) {
                        System.out.println(oldListRoot[oldListRoot.length-1]+" drive removed");
                        oldListRoot = File.listRoots();
                    }
                }
            }
        });
        t.start();
    }
    static String SO = System.getProperty("os.name");
    static String userDir = System.getProperty("user.home");
    static String Url=Confi.Url;
    
    public static void abrirArchivo(String url) throws IOException{
        File objetofile = new File (url);
        Desktop.getDesktop().open(objetofile);
    }
    public static void abrirDirecPri() throws IOException{
        if(SO.startsWith("Windows")){
            File directorio = new File(Url);
            Desktop.getDesktop().open(directorio);
        }else{
            File directorio = new File(userDir );
            Desktop.getDesktop().open(directorio);
        }
    }
}
