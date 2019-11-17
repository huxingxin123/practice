import java.io.*;
 /**
保存游戏数据
 */

public class Save  {
    Player player;

    public Save(Player player){
        this.player=player;
    }

    public void saveGame() throws IOException {
        File file=new File("f:"+File.separator+"save.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        OutputStream out=new FileOutputStream(file);
        String s=player.toString();
        byte[] b=s.getBytes();
        out.write(b);
        out.close();
    }
}
