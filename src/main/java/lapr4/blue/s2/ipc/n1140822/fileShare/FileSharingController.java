package lapr4.blue.s2.ipc.n1140822.fileShare;

import lapr4.green.s1.ipc.n1150532.comm.CommTCPClientsManager;
import lapr4.green.s1.ipc.n1150532.comm.connection.ConnectionID;
import lapr4.red.s3.ipc.n1150943.automaticDownload.DownloadInfo;
import lapr4.red.s3.ipc.n1150943.automaticDownload.persistence.DownloadsListPersistence;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Renato Oliveira 1140822@isep.ipp.pt
 */
public class FileSharingController {

    /**
     * The connection id.
     */
    private ConnectionID connection;




    public FileSharingController(ConnectionID connection) {
        this.connection = connection;
    }

    /**
     * Requests a file from another client.
     * 
     * @param fileName the filename from the file that was requested
     * @return true if requested went ok, false otherwise.
     */
    public boolean requestFile(String fileName) {
        CommTCPClientsManager.getManager().requestFile(connection, fileName);
        return true;
    }

    /**
     * Created by João Cardoso - 1150943
     * When adding a file to the downloads list, verfifies if it exists, it it does exist the download info
     * is updated, if it doesn't exist it is added to the list
     * @param filename
     * @param downloadInfo
     */
    public void addToDownloadsList(String filename, DownloadInfo downloadInfo){
        Map<String,DownloadInfo> downloads = DownloadsListPersistence.getDownloads();
        if(downloads.containsKey(filename)){
            downloads.replace(filename,downloadInfo);
        }else{
            downloads.put(filename,downloadInfo);
        }
        DownloadsListPersistence.saveList(downloads);
    }

}
