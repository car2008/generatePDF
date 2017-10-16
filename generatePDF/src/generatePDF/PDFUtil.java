package generatePDF;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.lowagie.text.Cell;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfGState;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.draw.LineSeparator;

public class PDFUtil {

	public static void main(String[] args) throws Exception {
		//stringWaterMark(createPDF(), "dajiahao");
		createPDF();
	}

	/**
	 * ����PDF�ĵ�
	 * 
	 * @return
	 * @throws Exception
	 * @throws docException
	 */
	public static String createPDF() throws Exception {

		// ���·��
		String outPath = "C:\\Users\\Administrator\\Desktop\\drugdeafness\\generatepdf//test.pdf";// DataUtil.createTempPath(".pdf");

		// ����ֽ��
		Rectangle rect = new Rectangle(PageSize.A4);

		// �����ĵ�ʵ��
		Document doc = new Document(rect);

		// �����������
		BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);

		// ����������ʽ
		Font textFont = new Font(bfChinese, 11, Font.NORMAL); // ����
		Font redTextFont = new Font(bfChinese, 11, Font.NORMAL, Color.RED); // ����,��ɫ
		Font boldFont = new Font(bfChinese, 11, Font.BOLD); // �Ӵ�
		Font redBoldFont = new Font(bfChinese, 11, Font.BOLD, Color.RED); // �Ӵ�,��ɫ
		Font firsetTitleFont = new Font(bfChinese, 22, Font.BOLD); // һ������
		Font secondTitleFont = new Font(bfChinese, 15, Font.BOLD); // ��������
		Font thirdTitleFont = new Font(bfChinese, 12, Font.BOLD); // 
		Font fourthTitleFont = new Font(bfChinese, 9, Font.NORMAL); // 
		Font underlineFont = new Font(bfChinese, 11, Font.UNDERLINE); // �»���б��
		Font headFont = new Font(bfChinese, 25, Font.BOLD);

		// ��ָͼƬ
		//Image hand = Image.getInstance("C:\\Users\\Administrator\\Desktop\\drugdeafness\\generatepdf\\title.jpg");

		// ���������
		PdfWriter.getInstance(doc, new FileOutputStream(new File(outPath)));

		doc.open();
		doc.newPage();

		// ����
		Paragraph p1 = new Paragraph();
		// ����
		Phrase ph1 = new Phrase();

		p1 = new Paragraph("xxxxxxҽԺ", firsetTitleFont);
		//p1.setLeading(50);
		p1.setAlignment(Element.ALIGN_CENTER);
		doc.add(p1);
		
		p1 = new Paragraph("ҩ���Զ��������ⱨ��", secondTitleFont);
		//p1.setLeading(50);
		p1.setAlignment(Element.ALIGN_CENTER);
		doc.add(p1);
		
		//ֱ��  
		p1 = new Paragraph("");  
		p1.add(new Chunk(new LineSeparator()));  
		doc.add(p1);  
		
		p1 = new Paragraph();
		p1.setSpacingBefore(10);
		p1.setSpacingAfter(10);
		ph1 = new Phrase();
		Chunk c15 = new Chunk(leftPad("���˻�����Ϣ", 1), thirdTitleFont);
		ph1.add(c15);
		p1.add(ph1);
		doc.add(p1);

		// ����һ����6�еı��
		PdfPTable table = new PdfPTable(6);
		table.setTotalWidth(new float[] { 80, 80, 80, 80,80,80 }); // �����п�
		table.setLockedWidth(true); // �����п�
		table.getDefaultCell().setBorder(Cell.TABLE);

		PdfPCell cell;
		cell = new PdfPCell(new Phrase("����", boldFont));
		//cell.setBorderWidthLeft(3);
		cell.setMinimumHeight(20); // ���õ�Ԫ��߶�
		cell.setUseAscender(true); // ���ÿ��Ծ���
		cell.setHorizontalAlignment(Cell.ALIGN_CENTER); // ����ˮƽ����
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(" ", textFont));
		cell.setUseAscender(true); // ���ÿ��Ծ���
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("�Ա�", boldFont));
		cell.setUseAscender(true); // ���ÿ��Ծ���
		cell.setHorizontalAlignment(Cell.ALIGN_CENTER); // ����ˮƽ����
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(" ", textFont));
		//cell.setBorderWidthRight(3);
		cell.setUseAscender(true); // ���ÿ��Ծ���
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("����", boldFont));
		cell.setUseAscender(true); // ���ÿ��Ծ���
		cell.setHorizontalAlignment(Cell.ALIGN_CENTER); // ����ˮƽ����
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(" ", textFont));
		//cell.setBorderWidthRight(3);
		cell.setUseAscender(true); // ���ÿ��Ծ���
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("�������", boldFont));
		//cell.setBorderWidthLeft(3);
		cell.setMinimumHeight(20); // ���õ�Ԫ��߶�
		cell.setUseAscender(true); // ���ÿ��Ծ���
		cell.setHorizontalAlignment(Cell.ALIGN_CENTER); // ����ˮƽ����
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(" ", textFont));
		cell.setUseAscender(true); // ���ÿ��Ծ���
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("�����/סԺ��", boldFont));
		cell.setUseAscender(true); // ���ÿ��Ծ���
		cell.setHorizontalAlignment(Cell.ALIGN_CENTER); // ����ˮƽ����
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(" ", textFont));
		//cell.setBorderWidthRight(3);
		cell.setUseAscender(true); // ���ÿ��Ծ���
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("����/��λ", boldFont));
		cell.setUseAscender(true); // ���ÿ��Ծ���
		cell.setHorizontalAlignment(Cell.ALIGN_CENTER); // ����ˮƽ����
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(" ", textFont));
		//cell.setBorderWidthRight(3);
		cell.setUseAscender(true); // ���ÿ��Ծ���
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("�ͼ����", boldFont));
		//cell.setBorderWidthLeft(3);
		cell.setMinimumHeight(20); // ���õ�Ԫ��߶�
		cell.setUseAscender(true); // ���ÿ��Ծ���
		cell.setHorizontalAlignment(Cell.ALIGN_CENTER); // ����ˮƽ����
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(" ", textFont));
		cell.setUseAscender(true); // ���ÿ��Ծ���
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("�ͼ�ҽ��", boldFont));
		cell.setUseAscender(true); // ���ÿ��Ծ���
		cell.setHorizontalAlignment(Cell.ALIGN_CENTER); // ����ˮƽ����
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(" ", textFont));
		//cell.setBorderWidthRight(3);
		cell.setUseAscender(true); // ���ÿ��Ծ���
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("�ͼ�����", boldFont));
		cell.setUseAscender(true); // ���ÿ��Ծ���
		cell.setHorizontalAlignment(Cell.ALIGN_CENTER); // ����ˮƽ����
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(" ", textFont));
		//cell.setBorderWidthRight(3);
		cell.setUseAscender(true); // ���ÿ��Ծ���
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("�ͼ�ʱ��", boldFont));
		//cell.setBorderWidthLeft(3);
		//cell.setBorderWidthTop(3);
		cell.setMinimumHeight(20); // ���õ�Ԫ��߶�
		cell.setUseAscender(true); // ���ÿ��Ծ���
		cell.setHorizontalAlignment(Cell.ALIGN_CENTER); // ����ˮƽ����
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(" ", textFont));
		//cell.setBorderWidthRight(3);
		cell.setUseAscender(true); // ���ÿ��Ծ���
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("��ע", boldFont));
		//cell.setBorderWidthLeft(3);
		//cell.setBorderWidthTop(3);
		cell.setMinimumHeight(20); // ���õ�Ԫ��߶�
		cell.setUseAscender(true); // ���ÿ��Ծ���
		cell.setHorizontalAlignment(Cell.ALIGN_CENTER); // ����ˮƽ����
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		table.addCell(cell);
		cell = new PdfPCell();
		//cell.setBorderWidthRight(3);
		//cell.setBorderWidthTop(3);
		cell.setUseAscender(true); // ���ÿ��Ծ���
		cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		cell.setColspan(3);
		table.addCell(cell);
		doc.add(table);
		
		p1 = new Paragraph();
		p1.setSpacingBefore(10);
		p1.setSpacingAfter(10);
		ph1 = new Phrase();
		Chunk c16 = new Chunk(leftPad("�����", 1), thirdTitleFont);
		ph1.add(c16);
		p1.add(ph1);
		doc.add(p1);
		
		PdfPTable t1 = new PdfPTable(4);
		// t1.getDefaultCell().setHorizontalAlignment(Cell.ALIGN_CENTER);
		t1.setTotalWidth(new float[]{120, 120, 120, 120});
		t1.setLockedWidth(true); // �����п�
		
		PdfPCell c2 ;
		c2 = new PdfPCell(new Phrase("���", boldFont));
		c2.disableBorderSide(4);
		c2.disableBorderSide(8);
		c2.setMinimumHeight(20); // ���õ�Ԫ��߶�
		c2.setUseAscender(true); // ���ÿ��Ծ���
		c2.setHorizontalAlignment(Cell.ALIGN_CENTER); // ����ˮƽ����
		c2.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		t1.addCell(c2);
		c2 = new PdfPCell(new Paragraph("�����Ŀ", boldFont));
		c2.disableBorderSide(4);
		c2.disableBorderSide(8);
		c2.setMinimumHeight(20); // ���õ�Ԫ��߶�
		c2.setUseAscender(true); // ���ÿ��Ծ���
		c2.setHorizontalAlignment(Cell.ALIGN_CENTER); // ����ˮƽ����
		c2.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		t1.addCell(c2);
		c2 = new PdfPCell(new Paragraph("���ֵ", boldFont));
		c2.disableBorderSide(4);
		c2.disableBorderSide(8);
		c2.setMinimumHeight(20); // ���õ�Ԫ��߶�
		c2.setUseAscender(true); // ���ÿ��Ծ���
		c2.setHorizontalAlignment(Cell.ALIGN_CENTER); // ����ˮƽ����
		c2.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		t1.addCell(c2);
		c2 = new PdfPCell(new Paragraph("�������ж�", boldFont));
		c2.disableBorderSide(4);
		c2.disableBorderSide(8);
		c2.setMinimumHeight(20); // ���õ�Ԫ��߶�
		c2.setUseAscender(true); // ���ÿ��Ծ���
		c2.setHorizontalAlignment(Cell.ALIGN_CENTER); // ����ˮƽ����
		c2.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		t1.addCell(c2);
		
		c2 = new PdfPCell(new Phrase("1", fourthTitleFont));
		c2.disableBorderSide(2);
		c2.disableBorderSide(4);
		c2.disableBorderSide(8);
		c2.setMinimumHeight(20); // ���õ�Ԫ��߶�
		c2.setUseAscender(true); // ���ÿ��Ծ���
		c2.setHorizontalAlignment(Cell.ALIGN_CENTER); // ����ˮƽ����
		c2.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		t1.addCell(c2);
		c2 = new PdfPCell(new Paragraph("FAM��1494 C > T��", fourthTitleFont));
		c2.disableBorderSide(2);
		c2.disableBorderSide(4);
		c2.disableBorderSide(8);
		c2.setMinimumHeight(20); // ���õ�Ԫ��߶�
		c2.setUseAscender(true); // ���ÿ��Ծ���
		c2.setHorizontalAlignment(Cell.ALIGN_CENTER); // ����ˮƽ����
		c2.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		t1.addCell(c2);
		c2 = new PdfPCell(new Paragraph("18.35", fourthTitleFont));
		c2.disableBorderSide(2);
		c2.disableBorderSide(4);
		c2.disableBorderSide(8);
		c2.setMinimumHeight(20); // ���õ�Ԫ��߶�
		c2.setUseAscender(true); // ���ÿ��Ծ���
		c2.setHorizontalAlignment(Cell.ALIGN_CENTER); // ����ˮƽ����
		c2.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		t1.addCell(c2);
		c2 = new PdfPCell(new Paragraph("���ԣ�+��", fourthTitleFont));
		c2.disableBorderSide(2);
		c2.disableBorderSide(4);
		c2.disableBorderSide(8);
		c2.setMinimumHeight(20); // ���õ�Ԫ��߶�
		c2.setUseAscender(true); // ���ÿ��Ծ���
		c2.setHorizontalAlignment(Cell.ALIGN_CENTER); // ����ˮƽ����
		c2.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		t1.addCell(c2);
		
		c2 = new PdfPCell(new Phrase("2", fourthTitleFont));
		c2.disableBorderSide(1);
		c2.disableBorderSide(2);
		c2.disableBorderSide(4);
		c2.disableBorderSide(8);
		c2.setMinimumHeight(20); // ���õ�Ԫ��߶�
		c2.setUseAscender(true); // ���ÿ��Ծ���
		c2.setHorizontalAlignment(Cell.ALIGN_CENTER); // ����ˮƽ����
		c2.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		t1.addCell(c2);
		c2 = new PdfPCell(new Paragraph("VIC��1555 A > G��", fourthTitleFont));
		c2.disableBorderSide(1);
		c2.disableBorderSide(2);
		c2.disableBorderSide(4);
		c2.disableBorderSide(8);
		c2.setMinimumHeight(20); // ���õ�Ԫ��߶�
		c2.setUseAscender(true); // ���ÿ��Ծ���
		c2.setHorizontalAlignment(Cell.ALIGN_CENTER); // ����ˮƽ����
		c2.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		t1.addCell(c2);
		c2 = new PdfPCell(new Paragraph("--", fourthTitleFont));
		c2.disableBorderSide(1);
		c2.disableBorderSide(2);
		c2.disableBorderSide(4);
		c2.disableBorderSide(8);
		c2.setMinimumHeight(20); // ���õ�Ԫ��߶�
		c2.setUseAscender(true); // ���ÿ��Ծ���
		c2.setHorizontalAlignment(Cell.ALIGN_CENTER); // ����ˮƽ����
		c2.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		t1.addCell(c2);
		c2 = new PdfPCell(new Paragraph("���ԣ�-��", fourthTitleFont));
		c2.disableBorderSide(1);
		c2.disableBorderSide(2);
		c2.disableBorderSide(4);
		c2.disableBorderSide(8);
		c2.setMinimumHeight(20); // ���õ�Ԫ��߶�
		c2.setUseAscender(true); // ���ÿ��Ծ���
		c2.setHorizontalAlignment(Cell.ALIGN_CENTER); // ����ˮƽ����
		c2.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		t1.addCell(c2);
		
		c2 = new PdfPCell(new Phrase("3", fourthTitleFont));
		c2.disableBorderSide(1);
		c2.disableBorderSide(4);
		c2.disableBorderSide(8);
		c2.setMinimumHeight(20); // ���õ�Ԫ��߶�
		c2.setUseAscender(true); // ���ÿ��Ծ���
		c2.setHorizontalAlignment(Cell.ALIGN_CENTER); // ����ˮƽ����
		c2.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		t1.addCell(c2);
		c2 = new PdfPCell(new Paragraph("NED���ʿأ�", fourthTitleFont));
		c2.disableBorderSide(1);
		c2.disableBorderSide(4);
		c2.disableBorderSide(8);
		c2.setMinimumHeight(20); // ���õ�Ԫ��߶�
		c2.setUseAscender(true); // ���ÿ��Ծ���
		c2.setHorizontalAlignment(Cell.ALIGN_CENTER); // ����ˮƽ����
		c2.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		t1.addCell(c2);
		c2 = new PdfPCell(new Paragraph("18.89", fourthTitleFont));
		c2.disableBorderSide(1);
		c2.disableBorderSide(4);
		c2.disableBorderSide(8);
		c2.setMinimumHeight(20); // ���õ�Ԫ��߶�
		c2.setUseAscender(true); // ���ÿ��Ծ���
		c2.setHorizontalAlignment(Cell.ALIGN_CENTER); // ����ˮƽ����
		c2.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		t1.addCell(c2);
		c2 = new PdfPCell(new Paragraph("���ԣ�+��", fourthTitleFont));
		c2.disableBorderSide(1);
		c2.disableBorderSide(4);
		c2.disableBorderSide(8);
		c2.setMinimumHeight(20); // ���õ�Ԫ��߶�
		c2.setUseAscender(true); // ���ÿ��Ծ���
		c2.setHorizontalAlignment(Cell.ALIGN_CENTER); // ����ˮƽ����
		c2.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		t1.addCell(c2);

		c2 = new PdfPCell(new Phrase("��ע", fourthTitleFont));
		c2.disableBorderSide(4);
		c2.disableBorderSide(8);
		c2.setMinimumHeight(20); // ���õ�Ԫ��߶�
		c2.setUseAscender(true); // ���ÿ��Ծ���
		c2.setHorizontalAlignment(Cell.ALIGN_CENTER); // ����ˮƽ����
		c2.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		t1.addCell(c2);
		c2 = new PdfPCell(new Paragraph("", textFont));
		c2.disableBorderSide(4);
		c2.disableBorderSide(8);
		c2.setMinimumHeight(20); // ���õ�Ԫ��߶�
		c2.setUseAscender(true); // ���ÿ��Ծ���
		c2.setHorizontalAlignment(Cell.ALIGN_CENTER); // ����ˮƽ����
		c2.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		t1.addCell(c2);
		c2 = new PdfPCell(new Paragraph("", textFont));
		c2.disableBorderSide(4);
		c2.disableBorderSide(8);
		c2.setMinimumHeight(20); // ���õ�Ԫ��߶�
		c2.setUseAscender(true); // ���ÿ��Ծ���
		c2.setHorizontalAlignment(Cell.ALIGN_CENTER); // ����ˮƽ����
		c2.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		t1.addCell(c2);
		c2 = new PdfPCell(new Paragraph("", textFont));
		c2.disableBorderSide(4);
		c2.disableBorderSide(8);
		c2.setMinimumHeight(20); // ���õ�Ԫ��߶�
		c2.setUseAscender(true); // ���ÿ��Ծ���
		c2.setHorizontalAlignment(Cell.ALIGN_CENTER); // ����ˮƽ����
		c2.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����
		t1.addCell(c2);
		doc.add(t1);
		
		Image img = Image.getInstance("resource/0003-Ұ����.bmp");  
		img.setAlignment(Image.ALIGN_CENTER | Image.TEXTWRAP);  
		img.setBorder(Image.BOX);  
		img.setBorderWidth(2);  
		img.setBorderColor(Color.WHITE);  
		img.scaleToFit(1300, 260);//��С  
		doc.add(img);  
		
		p1 = new Paragraph();
		ph1 = new Phrase();
		//Chunk c65 = new Chunk(hand, 0, 0);
		Chunk c71 = new Chunk(printBlank(115)+leftPad("ҩ���Զ��������������ʾ��ͼ",1), fourthTitleFont);
		//ph1.add(c65);
		ph1.add(c71);
		p1.add(ph1);
		doc.add(p1);
		
		p1 = new Paragraph();
		//p1.setSpacingBefore(20);
		//p1.setSpacingAfter(10);
		ph1 = new Phrase();
		//Chunk c62 = new Chunk(hand, 0, 0);
		Chunk c63 = new Chunk(leftPad("�����ʾ", 1), thirdTitleFont);
		//ph1.add(c62);
		ph1.add(c63);
		p1.add(ph1);
		doc.add(p1);

		p1 = new Paragraph();
		ph1 = new Phrase();
		//Chunk c65 = new Chunk(hand, 0, 0);
		Chunk c66 = new Chunk(leftPad("   �����ͼ�����Ϊ1494 C > Tͻ���͡�", 1), fourthTitleFont);
		//ph1.add(c65);
		ph1.add(c66);
		p1.add(ph1);
		doc.add(p1);
		
		p1 = new Paragraph();
		ph1 = new Phrase();
		//Chunk c65 = new Chunk(hand, 0, 0);
		Chunk c67 = new Chunk(leftPad("   ҩ���Զ������и��塣", 1), fourthTitleFont);
		//ph1.add(c65);
		ph1.add(c67);
		p1.add(ph1);
		doc.add(p1);
		
		p1 = new Paragraph();
		ph1 = new Phrase();
		//Chunk c65 = new Chunk(hand, 0, 0);
		Chunk c68 = new Chunk(leftPad("   ��ʾ���ö�����ҩ��ᵼ�¶�����Ӧ�������ö�����ҩ�", 1), fourthTitleFont);
		//ph1.add(c65);
		ph1.add(c68);
		p1.add(ph1);
		doc.add(p1);
		
		p1 = new Paragraph();
		ph1 = new Phrase();
		//Chunk c65 = new Chunk(hand, 0, 0);
		Chunk c69 = new Chunk(leftPad("   ���鱻�����������л����⣬��ȷ�����Ƿ�Ϊ�Ŵ��Զ������Ŵ��Զ�������ͻ��Я���ߡ�", 1), fourthTitleFont);
		//ph1.add(c65);
		ph1.add(c69);
		p1.add(ph1);
		doc.add(p1);
		
		p1 = new Paragraph();
		p1.setSpacingBefore(20);
		p1.setSpacingAfter(10);
		ph1 = new Phrase();
		//Chunk c65 = new Chunk(hand, 0, 0);
		Chunk c70 = new Chunk(printBlank(150)+leftPad("����Ա  _________ ���Ա  _________  ��������  _________ ",1), fourthTitleFont);
		//ph1.add(c65);
		ph1.add(c70);
		p1.add(ph1);
		doc.add(p1);
		
		p1 = new Paragraph();
		ph1 = new Phrase();
		//Chunk c65 = new Chunk(hand, 0, 0);
		Chunk c72 = new Chunk(leftPad("* ��������Ա����ͼ���Ʒ�����������ʣ���������ҽ����ϵ��",1), fourthTitleFont);
		//ph1.add(c65);
		ph1.add(c72);
		p1.add(ph1);
		doc.add(p1);

		doc.close();
		return outPath;
	}

	/**
	 * ������Ԫ��
	 * 
	 * @param table
	 * @param row
	 * @param cols
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	private static PdfPTable createCell(PdfPTable table, String[] title, int row, int cols)
			throws DocumentException, IOException {
		// �����������
		BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
		Font font = new Font(bfChinese, 11, Font.BOLD);

		for (int i = 0; i < row; i++) {

			for (int j = 0; j < cols; j++) {

				PdfPCell cell = new PdfPCell();

				if (i == 0 && title != null) {// ���ñ�ͷ
					cell = new PdfPCell(new Phrase(title[j], font)); // ������ͷ���ܾ���
					if (table.getRows().size() == 0) {
						cell.setBorderWidthTop(3);
					}
				}

				if (row == 1 && cols == 1) { // ֻ��һ��һ��
					cell.setBorderWidthTop(3);
				}

				if (j == 0) {// ������ߵı߿���
					cell.setBorderWidthLeft(3);
				}

				if (j == (cols - 1)) {// �����ұߵı߿���
					cell.setBorderWidthRight(3);
				}

				if (i == (row - 1)) {// ���õײ��ı߿���
					cell.setBorderWidthBottom(3);
				}

				cell.setMinimumHeight(40); // ���õ�Ԫ��߶�
				cell.setUseAscender(true); // ���ÿ��Ծ���
				cell.setHorizontalAlignment(Cell.ALIGN_CENTER); // ����ˮƽ����
				cell.setVerticalAlignment(Cell.ALIGN_MIDDLE); // ���ô�ֱ����

				table.addCell(cell);
			}
		}

		return table;
	}

	/**
	 * ��ˮӡ���ַ�����
	 * 
	 * @param inputFile
	 *            ��Ҫ��ˮӡ��PDF·��
	 * @param outputFile
	 *            �������PDF��·��
	 * @param waterMarkName
	 *            ˮӡ�ַ�
	 */
	public static void stringWaterMark(String inputFile, String waterMarkName) {
		try {
			String[] spe = DataUtil.separatePath(inputFile);
			String outputFile = spe[0] + "_WM." + spe[1];

			PdfReader reader = new PdfReader(inputFile);
			PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(outputFile));

			// �����������
			BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);

			int total = reader.getNumberOfPages() + 1;

			PdfContentByte under;
			int j = waterMarkName.length();
			char c = 0;
			int rise = 0;
			// ��ÿһҳ��ˮӡ
			for (int i = 1; i < total; i++) {
				rise = 400;
				under = stamper.getUnderContent(i);
				under.beginText();
				under.setFontAndSize(bfChinese, 30);
				under.setTextMatrix(200, 120);
				for (int k = 0; k < j; k++) {
					under.setTextRise(rise);
					c = waterMarkName.charAt(k);
					under.showText(c + "");
				}

				// ���ˮӡ����
				under.endText();
			}
			stamper.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ˮӡ��ͼƬ��
	 * 
	 * @param inputFile
	 *            ��Ҫ��ˮӡ��PDF·��
	 * @param outputFile
	 *            �������PDF��·��
	 * @param imageFile
	 *            ˮӡͼƬ·��
	 */
	public static void imageWaterMark(String inputFile, String imageFile) {
		try {
			String[] spe = DataUtil.separatePath(inputFile);
			String outputFile = spe[0] + "_WM." + spe[1];

			PdfReader reader = new PdfReader(inputFile);
			PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(outputFile));

			int total = reader.getNumberOfPages() + 1;

			Image image = Image.getInstance(imageFile);
			image.setAbsolutePosition(-100, 0);// ����
			image.scaleAbsolute(800, 1000);// �Զ����С
			// image.setRotation(-20);//��ת ����
			// image.setRotationDegrees(-45);//��ת �Ƕ�
			// image.scalePercent(50);//���ձ�������

			PdfGState gs = new PdfGState();
			gs.setFillOpacity(0.2f);// ����͸����Ϊ0.2

			PdfContentByte under;
			// ��ÿһҳ��ˮӡ
			for (int i = 1; i < total; i++) {
				under = stamper.getUnderContent(i);
				under.beginText();
				// ���ˮӡͼƬ
				under.addImage(image);
				under.setGState(gs);
			}
			stamper.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ������߾�
	 * 
	 * @param str
	 * @param i
	 * @return
	 */
	public static String leftPad(String str, int i) {
		int addSpaceNo = i - str.length();
		String space = "";
		for (int k = 0; k < addSpaceNo; k++) {
			space = " " + space;
		}
		;
		String result = space + str;
		return result;
	}

	/**
	 * ����ģ������
	 * 
	 * @param list
	 * @param num
	 */
	public static void add(List<String> list, int num) {
		for (int i = 0; i < num; i++) {
			list.add("test" + i);
		}
	}

	/**
     * ���ü��
     * @param tmp
     * @return
     */
    public static String printBlank(int tmp){
          String space="";
          for(int m=0;m<tmp;m++){
              space=space+" ";
          }
          return space;
    }
}