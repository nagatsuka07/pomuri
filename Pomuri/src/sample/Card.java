package sample;

import java.awt.Font;
import java.awt.Image;
import java.awt.image.ImageProducer;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Cardクラス
 * 画面切り替え用の各パネルの設定を行います
 * @author nagatsuka07
 * @version 1.0
 */
public class Card extends JFrame {

	/**
	 * 画面切り替え用の各パネルの設定を行います
	 * @param panel
	 * @param imgPath
	 * @param imgMsg
	 * @return 設定したパネル
	 */
	public JPanel createCard(JPanel panel, String imgPath, String imgMsg) {

		panel = new JPanel();

		// 表示する画像
	    JLabel labelIcon = new JLabel();
	    Image image=null;
	    URL url=this.getClass().getClassLoader().getResource(imgPath);
	    try {
	    	image=this.createImage((ImageProducer)url.getContent());
	    	labelIcon.setIcon(new ImageIcon(image));
	    }catch(Exception ex){
	    	ex.printStackTrace();
	    }
	    panel.add(labelIcon);

	    // 画像の説明
	    JLabel labelExplain = new JLabel(imgMsg);
	    labelExplain.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 30));
	    panel.add(labelExplain);

	    // 設定したパネルを返す
		return panel;
	}
}