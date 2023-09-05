/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.io.FileOutputStream;
import java.io.OutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
/**
 *
 * @author Pichau
 */
public class nota_DAO {
    public static void compra() throws DocumentException, FileNotFoundException, IOException {
        Document doc = null;
        OutputStream os = null;
   
        
        //aqui nois faz o preço só que precisa converter as outras variaveis de quant e prec e multiplicar as duas
        try {

            //cria o documento tamanho A4, margens de 2,54cm
            doc = new Document(PageSize.A4, 72, 72, 72, 72);

            //cria a stream de saída
            os = new FileOutputStream("C:\\Users\\Alunos\\Documents\\out.pdf");

            //associa a stream de saída ao
            PdfWriter.getInstance(doc, os);

            //abre o documento
            doc.open();

            //adiciona o texto ao PDF
            int cont2 = 1;
            float vlt = 0;
            
            Paragraph par = new Paragraph("MERCADO PEDREIRA\nNOTA FISCAL\n\n");
            par.setAlignment(Element.ALIGN_CENTER);
            doc.add(par);

            
            
            
            while(cont2 != 0){
                String prod = JOptionPane.showInputDialog(null,"Digite o nome do produto:\n");
                String quant2 = JOptionPane.showInputDialog(null,"Digite a quantidade do produto:\n");
                String preco = JOptionPane.showInputDialog(null,"Digite o preço do produto:\n");
       
                
                int quant = Integer.parseInt(quant2);
                float prec = Float.parseFloat(preco);
                float tot = quant*prec;
                vlt = vlt + tot;
                
                
                
                Paragraph par2 = new Paragraph(prod+"                 "+quant+"un "+tot+"R$");
                
                
                par2.setAlignment(Element.ALIGN_CENTER);
                
                doc.add(par2);    
                String c = JOptionPane.showInputDialog(null,"Deseja continuar?\n1 - Sim\n0 - Não");
                cont2 = Integer.parseInt(c);
            }
   
            String pag = JOptionPane.showInputDialog(null,"Digite a froma de pagamento: \n 1-crédito\n 2-Débito\n 3-Pix\n 4-Dinheiro\n  ");
                  
            
            Paragraph par3 = new Paragraph("\nTotal: R$"+vlt);
                
                
            par3.setAlignment(Element.ALIGN_CENTER);
                
            doc.add(par3);  
            
           
        } finally {

            if (doc != null) {

                //fechamento do documento
                doc.close();
            }

            if (os != null) {
                //fechamento da stream de saída
                os.close();
            }
        }
    
        Desktop.getDesktop().open(new File("C:\\Users\\Alunos\\Documents\\out.pdf"));
     }
     
    
    
   
}

