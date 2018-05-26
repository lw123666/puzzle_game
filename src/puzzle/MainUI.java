package puzzle;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	private JPanel contentPanel;
    private JPanel imagePanel;
    private JLabel timeLabel;
    private JMenuBar menuBar;
    private JMenu gameMenu = new JMenu("��Ϸ");
    private JMenu settingsMenu = new JMenu("����");
    private JMenuItem startItem = new JMenuItem("��ʼ ");
    private JMenuItem pauseItem = new JMenuItem("��ͣ");
    private JMenuItem stopItem = new JMenuItem("ֹͣ");
    private JMenuItem rankItem = new JMenuItem("������а�");
    private JMenuItem exitItem = new JMenuItem("�˳�");
    private JMenuItem gradeItem = new JMenuItem("�Ѷ�����");
    private JMenuItem picItem = new JMenuItem("ħ������");
    private JMenuItem musicItem = new JMenuItem("������������");
    
    private int grade = 3; //Ĭ���Ѷ�Ϊ3����3*3ʽƴͼ
    private String picName;
    
    public MainUI() {
    	frame = new JFrame("ƴͼ��Ϸ");
    	contentPanel =new JPanel();
    	timeLabel = new JLabel("00:00:00");
    	menuBar = new JMenuBar();
    	gameMenu.add(startItem);
    	gameMenu.addSeparator();
    	pauseItem.setEnabled(false);
    	stopItem.setEnabled(false);
    	gameMenu.add(pauseItem);
    	gameMenu.add(stopItem);
    	gameMenu.addSeparator();
    	gameMenu.add(rankItem);
    	gameMenu.add(exitItem);
    	menuBar.add(gameMenu);
    	settingsMenu.add(gradeItem);
    	settingsMenu.add(picItem);
    	settingsMenu.add(musicItem);
    	menuBar.add(settingsMenu);
    	frame.setJMenuBar(menuBar);
    	frame.getContentPane().add(BorderLayout.SOUTH, contentPanel);
    	contentPanel.setBorder(new EmptyBorder(5,5,5,5));
        contentPanel.setLayout(null);
        contentPanel.add(timeLabel);
        
        frame.setLayout(null);
        frame.setBounds(100, 100, 770, 560);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public void startGame() {
    	
    }
}