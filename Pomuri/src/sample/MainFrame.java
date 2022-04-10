package sample;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * MainFrameクラス
 * メインフレームの生成をします
 * @author nagatsuka07
 * @version 1.0
 */
public class MainFrame extends JFrame {

	public static JPanel cardPanel;
	public  static CardLayout cardLayout;
	public  static JPanel btnPanel;

	/**
	 * MainFrameクラスのコンストラクタ
	 * @param title
	 */
	public MainFrame(String title) {

		// メインフレームの設定
		setTitle(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(1000, 1000, 1000, 1000);
		setLocationRelativeTo(null);
		setResizable(false);

		// 画面切り替え用の親パネル生成
	    cardPanel = new JPanel();
	    cardLayout = new CardLayout();
	    cardPanel.setLayout(cardLayout);

	    // 画面切り替え用の各パネルの生成
	    String imgPath = "img/";
	    Card card = new Card();

	    // 初期画面パネルの生成
	    JPanel initCard = null;
	    initCard = card.createCard
	    		(initCard, imgPath + "yumekawa_bird4_blue.png", "あそぶ？");
	    MainFrame.cardPanel.add(initCard, "initCard");

	    // 「はなす」画面パネルの生成
	    JPanel talkCard0 = null;
	    JPanel talkCard1 = null;
	    JPanel talkCard2 = null;

	    talkCard0 = card.createCard
	    		(talkCard0, imgPath + "yumekawa_bird4_blue.png", "ぼくはぽむりだよ！");
	    talkCard1 = card.createCard
	    		(talkCard1, imgPath + "yumekawa_bird4_blue.png", "すきなものはわたあめなんだ～");
	    talkCard2 = card.createCard
	    		(talkCard2, imgPath + "yumekawa_bird4_blue.png", "いいおてんきだね！");

	    cardPanel.add(talkCard0, "talkCard0");
	    cardPanel.add(talkCard1, "talkCard1");
	    cardPanel.add(talkCard2, "talkCard2");

	    // 「うたう」画面パネルの生成
	    JPanel singCard0 = null;
	    JPanel singCard1 = null;
	    JPanel singCard2 = null;

	    singCard0 = card.createCard
	    		(singCard0, imgPath + "yumekawa_bird1_red.png", "らんらら～ん♪");
	    singCard1 = card.createCard
	    		(singCard1, imgPath + "yumekawa_bird3_green.png", "ぴゅ～るる♪♪");
	    singCard2 = card.createCard
	    		(singCard2, imgPath + "yumekawa_bird7_orange.png", "ぽんっぽこぽん♪");

	    cardPanel.add(singCard0, "singCard0");
	    cardPanel.add(singCard1, "singCard1");
	    cardPanel.add(singCard2, "singCard2");

	    // 「でかける」画面パネルの生成
	    JPanel goCard0 = null;
	    JPanel goCard1 = null;
	    JPanel goCard2 = null;

	    goCard0 = card.createCard
	    		(goCard0, imgPath + "hamster_sleeping_golden.png", "はむさんこんにちは！");
	    goCard1 = card.createCard
	    		(goCard1, imgPath + "animal_usagi_nihon_nousagi.png", "ぴょんぴょこぴょんっ");
	    goCard2 = card.createCard
	    		(goCard2, imgPath + "bird_uguisu.png", "もうはるだね！");

	    cardPanel.add(goCard0, "goCard0");
	    cardPanel.add(goCard1, "goCard1");
	    cardPanel.add(goCard2, "goCard2");

	    // ボタン用パネルの生成
		btnPanel = new JPanel();
		btnPanel.setPreferredSize(new Dimension(1000, 300));
		btnPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 100, 10));

		// ボタンの生成
	    Button button = new Button();
	    JButton talkBtn = null;
	    JButton singBtn = null;
	    JButton goBtn = null;

	    talkBtn = button.createButton(talkBtn, "はなす", "talk", new Color(135,206,250));
	    singBtn = button.createButton(singBtn, "うたう", "sing", new Color(255,182,193));
	    goBtn = button.createButton(goBtn, "でかける", "go", new Color(255,215,0));

	    btnPanel.add(talkBtn);
	    btnPanel.add(singBtn);
	    btnPanel.add(goBtn);

		// 生成したパネルをペインに追加
	    getContentPane().add(cardPanel, BorderLayout.CENTER);
	    getContentPane().add(btnPanel, BorderLayout.PAGE_END);
	}
}