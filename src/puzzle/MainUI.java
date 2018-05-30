package puzzle;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
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
    private JMenuItem startItem = new JMenuItem("��ʼ");
    private JMenuItem pauseItem = new JMenuItem("��ͣ");
    private JMenuItem stopItem = new JMenuItem("ֹͣ");
    private JMenuItem rankItem = new JMenuItem("������а�");
    private JMenuItem exitItem = new JMenuItem("�˳�");
    private JMenuItem gradeItem = new JMenuItem("�Ѷ�����");
    private JMenuItem picItem = new JMenuItem("ħ�����ÿ�");
    private JMenuItem nextPicItem = new JMenuItem("��һ�ű���ͼ");
    private JMenuItem musicItem = new JMenuItem("�������ֿ�");
    private JMenuItem nextMusicItem = new JMenuItem("��һ�ױ�������");
    
    boolean isPic = false;//�Ƿ��б���ͼƬ
    int isPause = 0;//�Ƿ���ͣ    
    private int grade = 3; //Ĭ���Ѷ�Ϊ3����3*3ʽƴͼ
    private String[] picNameList = {"1", "2", "3"};
    private String[] musicList = {"1", "2", "3"};
    private int picIndex = 0;
    private int musicIndex = 0;
    private int time = 0;
    private int blankRow = 2;
    private int blankCol = 2;
    private ImageButton[][] btnField = null;
    private int[][] numField;
    
    private Timer timer;
    private AudioClip a;
    
    public MainUI() {
    	contentPanel = new JPanel();
    	contentPanel.setBorder(new EmptyBorder(5,5,5,5));
        contentPanel.setLayout(null);
        
        timeLabel = new JLabel("");
        timeLabel.setFont(new Font("Dialog", 1, 15));
    	timeLabel.setBounds(10, 10, 495, 50);
    	
    	imagePanel = new JPanel();
    	
        imagePanel.setBounds(10, 60, 450, 450);
        contentPanel.add(imagePanel);
        
    	contentPanel.add(timeLabel);
    	
    	startItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
    	pauseItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
    	stopItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
    	rankItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
    	exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
    	
    	startItem.addActionListener(new MenuItemActionListener());
    	pauseItem.addActionListener(new MenuItemActionListener());
    	stopItem.addActionListener(new MenuItemActionListener());
    	rankItem.addActionListener(new MenuItemActionListener());
    	exitItem.addActionListener(new MenuItemActionListener());
    	gradeItem.addActionListener(new MenuItemActionListener());
    	picItem.addActionListener(new MenuItemActionListener());
    	nextPicItem.addActionListener(new MenuItemActionListener());
    	musicItem.addActionListener(new MenuItemActionListener());
    	nextMusicItem.addActionListener(new MenuItemActionListener());
    	
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
    	nextPicItem.setEnabled(false);
    	nextMusicItem.setEnabled(false);
    	settingsMenu.add(gradeItem);
    	settingsMenu.addSeparator();
    	settingsMenu.add(picItem);
    	settingsMenu.add(nextPicItem);
    	settingsMenu.addSeparator();
    	settingsMenu.add(musicItem);
    	settingsMenu.add(nextMusicItem);
    	menuBar.add(settingsMenu);
    	
    	
    	this.setJMenuBar(menuBar);
    	this.setContentPane(contentPanel);    
    	this.setTitle("ħ����Ϸ");
        
    	this.setLayout(null);
        this.setBounds(100, 100, 495, 595);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void startGame() {
    	startItem.setEnabled(false);
    	pauseItem.setEnabled(true);
    	stopItem.setEnabled(true);
    	timeLabel.setText(getStringTime());
    	imagePanel.setBackground(Color.ORANGE);
    	
    	time = 0;
    	
    	init();
    	
    	ImageCtrl ic = new ImageCtrl(picNameList[picIndex]);
    	ic.deletePic();
    	ic.cutPic(grade, grade, grade);
    	
    	for (int i = 0; i < grade; i++) {
    		for (int j = 0; j < grade; j++) {
    			ImageButton ib = new ImageButton(i, j, 450 / grade, numField[i][j], picNameList[picIndex], isPic);
    			imagePanel.add(ib);
    			btnField[i][j] = ib;
    			ib.addActionListener(new ImageButtonActionListener());
    		}
    	}
    	
    	blankRow = grade - 1;
    	blankCol = grade - 1;
    	btnField[blankRow][blankCol].setImage(false, isPic);
    	
    }
    
    public void init() {
    	Random random = new Random();
    	
    	btnField = new ImageButton[grade][grade];
    	imagePanel.removeAll();
    	imagePanel.setLayout(new GridLayout(grade, grade));
    	
    	numField =  new int[grade][grade];
    	for (int i = 0; i < grade; i++) {
    		for (int j = 0; j< grade; j++) {
    			numField[i][j] = i * grade + j + 1;
    		}
    	}
    	
    	//�����������
    	for (int i = 0; i < grade; i++) {
            for (int j = 0; j < grade; j++) {
                if ((i == grade - 1) && (j == grade - 1))
                    break;//���һ���������
                //���ѡ��һ��λ�ã��͵�ǰλ�õ�����
                int x = random.nextInt(grade - 1);
                int y = random.nextInt(grade - 1);
                if (x == grade - 1 && y == grade - 1) {
                    continue;
                }
                int temp = numField[i][j];
                numField[i][j] = numField[x][y];
                numField[x][y] = temp;
            }
        }
    }
    
    public String getStringTime() {
    	int second = time % 60;
		int m = time / 60;
		int minute = m % 60;
		int hour = m / 60;
		String se = "", mi = "", ho = "";
		if (second >= 10) {
			se = se + String.valueOf(second);
		} else {
			se = se + "0" + String.valueOf(second);
		}
		if (minute >= 10) {
			mi = mi + String.valueOf(minute);
		} else {
			mi = mi + "0" + String.valueOf(minute);
		}
		if (hour >= 10) {
			ho = ho + String.valueOf(hour);
		} else {
			ho = ho + "0" + String.valueOf(hour);
		}
		return ho+":"+mi+":"+se;
    }
    
    class MenuItemActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String cmd = e.getActionCommand();
			if (cmd.equals("��ʼ")) {
				startGame();
				startThread();
			} else if (cmd.equals("�˳�")) {
				System.exit(0);
			} else if (cmd.equals("��ͣ")) {
			    timeLabel.setText("��ͣ");
			    isPause = 1;
			    timer.cancel();
			    pauseItem.setText("����");
			} else if (cmd.equals("����")) {
				timeLabel.setText(getStringTime());
				startThread();
				isPause = 0;
				pauseItem.setText("��ͣ");
			} else if (cmd.equals("ֹͣ")) {
				timer.cancel();
				timeLabel.setText("");
				imagePanel.removeAll();
				imagePanel.setBackground(Color.GRAY);
				startItem.setEnabled(true);
				pauseItem.setText("��ͣ");
				pauseItem.setEnabled(false);
				stopItem.setEnabled(false);
			} else if (cmd.equals("������а�")) {
				RankUI r = new RankUI();
			} else if (cmd.equals("�Ѷ�����")) {
				String g = JOptionPane.showInputDialog("�������Ѷȣ���ƴͼ��������?");
				boolean isNum = true;
				if (g.equals("")) {
					grade = 3;
				} else {
					for (int i = 0; i < g.length(); i++) {  
						if (!Character.isDigit(g.charAt(i))) {
							isNum = false;
						}
					}
					if(isNum) {
						grade = Integer.parseInt(g);
					} else {
						JOptionPane.showMessageDialog(frame, "���������֣���","warning",JOptionPane.WARNING_MESSAGE);
					}
				}
			} else if (cmd.equals("�������ֿ�")) {			
				musicItem.setText("�������ֹ�");
				File f = new File("music/" + musicList[musicIndex] + ".wav");
				try {
					a = Applet.newAudioClip(f.toURI().toURL());
					a.loop();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				nextMusicItem.setEnabled(true);
			} else if (cmd.equals("�������ֹ�")) {
				musicItem.setText("�������ֿ�");
				a.stop();
				nextMusicItem.setEnabled(false);
			} else if (cmd.equals("ħ�����ÿ�")) {
				isPic = true;
				picItem.setText("ħ�����ù�");
				nextPicItem.setEnabled(true);
			} else if (cmd.equals("ħ�����ù�")) {
				isPic = false;
				picItem.setText("ħ�����ÿ�");
				nextPicItem.setEnabled(false);
			} else if (cmd.equals("��һ�ű���ͼ")) { 
				picIndex = (picIndex + 1) % 3;
			} else if (cmd.equals("��һ�ױ�������")) {
				musicIndex = (musicIndex + 1) % 3;
				a.stop();
				File f = new File("music/" + musicList[musicIndex] + ".wav");
				try {
					a = Applet.newAudioClip(f.toURI().toURL());
					a.loop();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
    	
    }
    
    class ImageButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (isPause == 1) {
				
			}else {
				ImageButton btn = (ImageButton)e.getSource();
				int row = btn.getRow();
				int col = btn.getCol();
				//�ж��Ƿ���հ׿�����
				if ((Math.abs(row - blankRow) + Math.abs(col - blankCol)) == 1) {
					int temp = btnField[row][col].getNum();
					System.out.println(temp + " " +btnField[blankRow][blankCol].getNum());
					btnField[row][col].setNum(btnField[blankRow][blankCol].getNum());
		            btnField[blankRow][blankCol].setNum(temp);
		            btnField[blankRow][blankCol].setImage(true, isPic);
		            btnField[row][col].setImage(false, isPic);
		            
		            temp = numField[row][col];
		            numField[row][col] = numField[blankRow][blankCol];
		            numField[blankRow][blankCol] = temp;
		            
		            blankCol = col;
		            blankRow = row;
		            
		            if (isGameOver()) {
		            	String name = JOptionPane.showInputDialog("��Ӯ�ˣ�����������������ɣ�");
		            	Player p = new Player(name, time, grade);
		            	PlayerMethod pm = new PlayerMethod();
		            	pm.add(p);
		            	
		            	//����Ϸ���滹ԭ
		            	timeLabel.setText("");
						imagePanel.removeAll();
						imagePanel.setBackground(Color.GRAY);
						startItem.setEnabled(true);
						pauseItem.setText("��ͣ    Ctrl+P");
						pauseItem.setEnabled(false);
						stopItem.setEnabled(false);
		            }
				}
			}
		}
    	
    }
    
    public boolean isGameOver() {
    	for (int i = 0; i < grade; i++) {
    		for (int j = 0; j < grade; j++) {
    			if (numField[i][j] != i * grade + j + 1) {
    				return false;
    			}
    		}
    	}
    	
    	return true;
    }
    
    public class MyTask extends TimerTask {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			time++;
			timeLabel.setText(getStringTime());
		}
    	
    }
    
    public void startThread() {
    	if (timer != null) {
    		timer.cancel();
    	}
    	timer = new Timer();
    	timer.scheduleAtFixedRate(new MyTask(), 1000, 1000);
    }
    
}