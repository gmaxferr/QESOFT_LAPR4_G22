/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1060503.chat.profile;

import eapli.framework.domain.AggregateRoot;
import eapli.util.Strings;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.swing.ImageIcon;

/**
 * represent local the user chat 
 * @author Pedro Fernandes
 */
@Entity
public class UserChatProfile implements AggregateRoot<Long>, Serializable{
    
    private static final long serialVersionUID = 1L;

    // ORM primary key
    @Id
    @GeneratedValue
    private Long pk;
    @Version
    private Long version;
    
    /**
     * name of the system
     */
    private final String username = System.getProperty("user.name");
    /**
     * nickname of user chat
     */
    private String nickname;
   
    /**
     * byte of the icon
     */
    private byte[] iconBytes;
    
     /**
     * icon or image of user chat
     */
    private ImageIcon icon;
    /**
     * the status (online or offline) of user chat
     */
    private StatusChatProfile status;
    
    
    /**
     * path of default icon
     */
    private final URL DEFAULT_ICON_PATH = 
            getClass().getClassLoader().getResource("lapr4/blue/s2/ipc/n1060503/chat/img/default_icon.png");
    
    /**
     * constructor by default
     * @throws java.io.IOException
     */
    public UserChatProfile() throws IOException{
        nickname = username;
        this.icon = changeIcon("");
        //iconBytes = Files.readAllBytes(file.toPath());
        status = StatusChatProfile.ONLINE;
    }
    
    /**
     * change all info of user chat profile
     * @param nickname
     * @param image_path
     * @param status 
     * @return changed user chat profile
     * @throws java.net.MalformedURLException
     */
    public UserChatProfile changeInfo(String nickname, String image_path, 
            StatusChatProfile status) throws MalformedURLException {
        if (status == null) {
            throw new IllegalStateException("Invalid status");
        }
        if(Strings.isNullOrEmpty(nickname)){
            throw new IllegalStateException("Invalid nickname");
        }

        if(!this.setStatus(status)){
            throw new IllegalStateException("Invalid status");
        }
        this.icon = changeIcon(image_path);
       
        this.nickname = nickname;

        return this;
    }
    
    /**
     * change the icon or imagem of user chat
     * @param image_path icon or image path
     * @return the new icon or imagem of user chat
     */
    private ImageIcon changeIcon(String image_path) throws MalformedURLException{
        ImageIcon i;
        
        if(image_path.isEmpty()){
            i = new ImageIcon(DEFAULT_ICON_PATH);
        }else{
            URL url = new URL(image_path);
            i = new ImageIcon(url);
        }
        
        return i;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof UserChatProfile)) {
            return false;
        }
        
        final UserChatProfile that = (UserChatProfile) other;
        if (this == that) {
            return true;
        }
        
        return id().equals(that.id()) && username.equals(that.username);
    }

    @Override
    public boolean is(Long id) {
        return id().equals(id);
    }

    @Override
    public Long id() {
        return this.pk;
    }
    
    /**
     * @return the username
     */
    public String getUsername(){
        return this.username;
    }

    /**
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @return the status
     */
    public StatusChatProfile getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     * @return true if status is valid, false if not
     */
    public boolean setStatus(StatusChatProfile status) {
        
        if(! (status instanceof StatusChatProfile) ){
            return false;
        }
        this.status = status;
        return true;
    }
    
    @Override
    public String toString(){
        return this.nickname + this.status;
    }
    
    public ImageIcon getImage(){
        return this.icon;
    }
}
