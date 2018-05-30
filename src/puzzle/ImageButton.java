package puzzle;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 *  @author Administrator
 *  �µİ�ť�࣬������Ϸ����ʾͼƬ��
 *
 */
public class ImageButton extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * col: int ��
	 * row: int ��
	 * length: int ��С
	 * num: int ���
	 * picName��  String ͼƬ��
	 */
	private int col;
	private int row;
	private int length;
	private int num;
	private String picName;
	
	public ImageButton(int row, int col, int length, int num, String picName, boolean isPic) {
		this.row = row;
		this.col = col;
		this.length = length;
		this.num = num;
		this.picName = picName;
		setImage(true, isPic);
	}
	
	//����ť����ͼƬ
	public void setImage(boolean isShow, boolean isPic) {
		if (isShow) {
			if (isPic) {
				String imagePath = "image/" + picName + "/" + num + ".png";
				ImageIcon icon = new ImageIcon(imagePath);
				icon.setImage(icon.getImage().getScaledInstance(length, length, Image.SCALE_DEFAULT));
				this.setIcon(icon);
				this.setText("");
			} else {
				this.setFont(new Font("Dialog", 1, 40));
				this.setText(String.valueOf(num));
				this.setIcon(null);
			}
		} else {
			this.setText("");
			this.setIcon(null);
		}
	}
	
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPicName() {
		return picName;
	}
	public void setPicName(String picName) {
		this.picName = picName;
	}
	
	

}
