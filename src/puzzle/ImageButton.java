package puzzle;

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
	
	public ImageButton(int col, int row, int length, int num, String picName) {
		this.col = col;
		this.row = row;
		this.length = length;
		this.num = num;
		this.picName = picName;
		setImage(true);
	}
	
	//����ť����ͼƬ
	public void setImage(boolean isShow) {
		if (isShow) {
			String imagePath = "images/" + picName + "/" + num + ".jpg";
			ImageIcon icon = new ImageIcon(imagePath);
			icon.setImage(icon.getImage().getScaledInstance(length, length, Image.SCALE_DEFAULT));
			this.setIcon(icon);
		} else {
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
