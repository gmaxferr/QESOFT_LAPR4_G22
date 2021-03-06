/**
 * Technical documentation regarding the user story IPC08.1: Share files. 
 * <p>
 *
 * <b>Requirement</b><p>
 * Statement:<p>
 * Cleansheets should have a new option to share the files contained in a specific directory. The user should
be able to specify the directory to share (output). These files should now be listed on other instances
of Cleansheets (in a specific window, for instance, in a sidebar). The list should include the name of
the files and its size. It is also required to configure the local directory that will receive the downloaded
files (input). The configuration of file sharing should be persistent. For the moment it is not required to
implement the download of files, however it is necessary to keep the list of files updated automatically.
It is also necessary to update the list of files that where selected for download in the input list. This list
should include the name of the file, its size, its source and its status (download in progress, up to date,
etc.)<p>
 * 
 * <b>Analysis</b><p>
 * <img src="us96_analysis" alt="image"> 
 * <p>
 * <b>Notes:</b><p>
 * Class CliSharer: This class will communicate with the server by giving the folder where the Files for download are.<p>
 * One possibility is for this class to handle in the same socket the information of all files.<p>
 * For this to work we could implement a pattern like "producer-consumer" where CliSharer would be producer and we could have several consumers for each type of subclass of DTO (Data Transfer Object).<p>
 * According to the type of DTO CliSharer would "pass" control to the specific consumer that would "handle" the received DTO.<p>
 * Class cliReceivers: this class will comunicate with the server by receiving the list of files that are available for download. It will save the files on a specific folder selected by the diferent instances.  <p>
 * 
 *<b>Brief</b><p>
 * The user opens the app and selects the extension for sharing files.
 * The system request the path of the folder where the files he wants to send are.
 * The user selects the path and start share. The system establishes a
 * connection and request. The system get the files list. The other instances, may
 * establish connection with the server and they will see the files list they can download.
 * 
 * 
 * <b>Tests</b><p>
 * This should be unit tests <p>
 * 
 * <b>Test:</b> FileListTest<p>
 * Test if the info of the files was successfully sent to the server.
 * 
 * 
 * <b>Design</b><p>
 * First draft regarding the design.<p>
 * .<p>
 * 
 * 
 * @author Joao
 */
package lapr4.green.s1.ipc.n1140925.fileShare;