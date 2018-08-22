import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class FileServiceImpl implements FileService{

    FileInformation fileInfo= new FileInformation();

    @Override
    public String[] getFileInfo() {
        File files = new File("C:\\Users\\Liam\\Documents");
        String[] fileInformation = new String[(int) files.length()];
/*
        int index = 0;

        for(File file : files.listFiles()){
            try {
                fileInformation[index] = fileInfo.getFileName()+" "
            }
        */
        return new String[0];


    }
}
