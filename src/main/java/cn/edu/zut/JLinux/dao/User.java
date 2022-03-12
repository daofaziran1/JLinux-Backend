package cn.edu.zut.JLinux.dao;

public class User {
    private String userName;
    private int uid; // user id
    private int gid; // group id
    private String gecos; // 用户的详细信息（如姓名，年龄，电话等）
    private String homeDirectory;// 用户文件夹
    // private String shell;//默认shell
    // private String password;//密码
    private String passwordHash;// 加密后的密码
    private long lastChanged; // 上次修改时间
    private long lastLogin; // 上次登录时间
    private String cwd;

    public User(String userName, int uid, int gid, String gecos, String homeDirectory) {
        this.userName = userName;
        this.uid = uid;
        this.gid = gid;
        this.gecos = gecos;
        this.homeDirectory = homeDirectory;
        passwordHash = null;
        lastLogin = 0;
        lastChanged = System.currentTimeMillis();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGecos() {
        return gecos;
    }

    public void setGecos(String gecos) {
        this.gecos = gecos;
    }

    public String getHomeDirectory() {
        return homeDirectory;
    }

    public void setHomeDirectory(String homeDirectory) {
        this.homeDirectory = homeDirectory;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public long getLastChanged() {
        return lastChanged;
    }

    public void setLastChanged(long lastChanged) {
        this.lastChanged = lastChanged;
    }

    public String getCwd() {
        return cwd;
    }

    public void setCwd(String cwd) {
        this.cwd = cwd;
    }

    public long getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(long lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return userName + ":"+passwordHash+":" + uid + ":" + gid + ":" + gecos + ":" + homeDirectory;
    }
}
