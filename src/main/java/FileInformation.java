public class FileInformation {

private String fileName;
private String fileMimeType;
private int fileSize;
private String fileExtension;
private Vehicle vehicle;


    public String getFileName() {
        return fileName;
    }

    public String getFileMimeType() {
        return fileMimeType;
    }

    public int getFileSize() {
        return fileSize;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileMimeType(String fileMimeType) {
        this.fileMimeType = fileMimeType;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public FileInformation(){}


}
