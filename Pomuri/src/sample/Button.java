package sample;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Buttonクラス
 * ボタンに関する設定を行います
 * @author nagatsuka07
 * @version 1.0
 */
public class Button extends JFrame implements ActionListener {

	/**
	 * ボタンの設定を行います
	 * @param button
	 * @param buttonName
	 * @param cmdtype
	 * @param color
	 * @return 設定したボタン
	 */
	public JButton createButton(JButton button, String buttonName,String cmdtype, Color color) {

		// ボタンの設定
		button = new JButton(buttonName);
		button.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 30));
		button.setForeground(Color.WHITE);
		button.setBackground(color);
		button.setBorderPainted(false);
		button.setPreferredSize(new Dimension(200, 100));

		// ボタン押下時のアクションを設定
		button.addActionListener(this);
		button.setActionCommand(cmdtype);

		// 設定したボタンを返す
		return button;
	}

	/* (非 Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * 各ボタン押下時の処理を行う
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// setActionCommandの引数（ボタンの種類）を代入
		String cmdtype = e.getActionCommand();

		// cmd変数の初期化
		String cmd = null;

		// どの画面を表示させるかランダムで決めるための値生成
		Random rnd = new Random();
		int intRnd = rnd.nextInt(4);

		// 「はなす」ボタン押下時にどの画面を表示するか設定する
		if (cmdtype.equals("talk")) {
			if (intRnd == 0) {
				cmd = "talkCard0";
			} else if (intRnd == 1) {
				cmd = "talkCard1";
			} else if (intRnd == 2) {
				cmd = "talkCard2";
			} else if (intRnd == 3) {
				cmd = "talkCard3";
			}

		// 「うたう」ボタン押下時にどの画面を表示するか設定する
		} else if (cmdtype.equals("sing")) {
			if (intRnd == 0) {
				cmd = "singCard0";
			} else if (intRnd == 1) {
				cmd = "singCard1";
			} else if (intRnd == 2) {
				cmd = "singCard2";
			}

		// 「でかける」ボタン押下時にどの画面を表示するか設定する
		} else if (cmdtype.equals("go")) {
			if (intRnd == 0) {
				cmd = "goCard0";
			} else if (intRnd == 1) {
				cmd = "goCard1";
			} else if (intRnd == 2) {
				cmd = "goCard2";
			}

		// 上記以外の場合は初期画面を表示する
		}else {
			cmd = "initCard";
		}

		// 実際に表示する画面の設定をする
		MainFrame.cardLayout.show(MainFrame.cardPanel, cmd);
	}
}