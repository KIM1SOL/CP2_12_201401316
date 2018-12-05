import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class URLbulider implements ActionListener {
	private JButton nb;
	private JTextField jt;
	private URL url;
	String data, trueData;
	private JEditorPane pane,pane2;
	private URLConnection urlconn;
	private BufferedReader in;
	
	public void HtmlEditor() throws Exception {
		JFrame frame = new JFrame();
		frame.setTitle("HTML 보기");
		BorderLayout border = new BorderLayout(4,4);
		frame.setLayout(border);
		
		JPanel windowPanel, inputPanel;
		windowPanel = new JPanel();
		inputPanel = new JPanel();
		
		
		JLabel lb = new JLabel("URL");
		inputPanel.add(lb);
		jt = new JTextField();
		jt.setColumns(30);
		inputPanel.add(jt);
		nb = new JButton("HTML 가져오기");
		nb.addActionListener(this); //***********************
		inputPanel.add(nb);
		
		
		pane = new JEditorPane();
		pane2 = new JEditorPane();
		
		frame.add(windowPanel, BorderLayout.CENTER);
		frame.add(inputPanel, BorderLayout.SOUTH);
		
		pane.setContentType("text/plain");
		pane.setEditable(false);
		
		
		pane2.setContentType("text/html");
		pane2.setEditable(false);
		
		pane.setSize(500, 200);
		pane2.setSize(500, 200);
		
		JScrollPane Jspane = new JScrollPane(pane);
		JScrollPane Jspane2 = new JScrollPane(pane2);
		
		windowPanel.add(Jspane);
		windowPanel.add(Jspane2);
		
		windowPanel.setLayout(new GridLayout(2,1));
		
		/*
		URL url = new URL("https://docs.oracle.com/javase/7/docs/api/javax/swing/JEditorPane.html");
		URLConnection urlconn = url.openConnection();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(urlconn.getInputStream()));
		
		
		while((data= in.readLine())!= null) {
			trueData += data+"\n";
		};
		in.close();
		
		pane.setText(trueData);
		pane2.setText(trueData);
		*/
		
		frame.setSize(500,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == nb) {
			try {
				System.out.println(jt.getText());
				url = new URL(jt.getText());
				urlconn = url.openConnection();
				in = new BufferedReader(new InputStreamReader(urlconn.getInputStream()));
				while((data= in.readLine())!= null) {
					trueData += data+"\n";
				};
				in.close();
				System.out.println(trueData);
			} catch (Exception e1) {
				e1.printStackTrace();
				trueData = "helloworld";
			}
			
			pane.setText(trueData);
			pane2.setText(trueData);
		}
	}
}
