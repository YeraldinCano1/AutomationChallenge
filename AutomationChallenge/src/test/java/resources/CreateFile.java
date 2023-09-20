package resources;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class CreateFile {
	File file;
	public CreateFile(String name) throws IOException {
		String route="/Files/"+name;
		file = new File(route);
        // Si el archivo no existe es creado
        if (!file.exists()) {
            file.createNewFile();
        }
	}
	
	public void Write(String text) throws IOException {
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
        bw.write(text);
        bw.close();
	}
    
    
}
