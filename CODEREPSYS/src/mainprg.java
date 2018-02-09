import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.xml.soap.Text;

public class mainprg extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public static void CodeMenuSys()
	{
	
	JFrame pm = new JFrame("Prjmenu");
	MenuBar menuB =new MenuBar();
	Menu menu = new Menu("DOCUMENT REPOSITORY SYSTEM");
	Menu submenu = new Menu("NEW PROJECT");
	
	
	//MenuItem project = new MenuItem("PROJECT");
	MenuItem createProject =new MenuItem("CREATE PROJECT");
	MenuItem Import =new MenuItem("IMPORT FILE");
	MenuItem SubProj1 =new MenuItem("SUB NEW PROJECT1");
	MenuItem Subproj2 =new MenuItem("SUB NEW PROJECT2");
	MenuItem Subproj3 =new MenuItem("SUB NEW PROJECT3");
	
	
	//menu.add(project);
	submenu.add(createProject);
	submenu.add(SubProj1);
	submenu.add(Subproj2);
	submenu.add(Subproj3);
	menu.add(submenu);
	menuB.add(menu);
	
	pm.setMenuBar(menuB);
	pm.setSize(400, 400);
	pm.setVisible(true);
	pm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	createProject.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e) {
					File file =new File("C:\\MAINPROJECT");
					if(!file.exists())
					{
						if(file.mkdir())
						{
							System.out.println("MAIN PROJECT GOT CREATED");
							fileFilterDoc();
						}
						else
						{
							System.out.println("MAIN PROJECT NOT CREATED");
						}
					}
					
					File file1 = new  File("C:\\MAINPROJECT\\PROJECT1");
					if(!file1.exists())
					{
						if(file1.mkdir())
						{
							System.out.println("MAINPROJECT WITH SUB PROJECT1 GOT CREATED");
							fileFilterPPt();
						}
						else
						{
							System.out.println("MAINPROJECT WITH SUB PROJECT1  NOT CREATED");
						}
					}
				}

				private void fileFilterPPt() {
					JFileChooser chooser = new JFileChooser();
					File file1 =new File("C:\\MAINPROJECT\\PROJECT1\\PROJECTA");
					File selectedFileNameDir, selectedFileNamePath;
					int Checker;
					chooser.setCurrentDirectory(file1);
					chooser.setFileSelectionMode(chooser.FILES_ONLY);
					chooser.addChoosableFileFilter(new FileFilterprg("MS Office Documents", "pptx"));
					
					chooser.setAcceptAllFileFilterUsed(true);
					Checker =chooser.showOpenDialog(null);
					if(Checker ==JFileChooser.APPROVE_OPTION)
					{
						selectedFileNamePath = chooser.getCurrentDirectory();
						selectedFileNameDir = chooser.getSelectedFile();
						System.out.println("Selected file path  "+selectedFileNamePath.getAbsolutePath());
						System.out.println("selected file name"+selectedFileNameDir.getName());
					   
					   	 String name =chooser.getSelectedFile().getAbsolutePath();		
							try {
								FileWriter fw=new FileWriter(chooser.getSelectedFile());
								fw.write(name);
								fw.flush();
								fw.close();
							
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					
						
					}
								
	
					else
					{
						JOptionPane.showMessageDialog(null,"You have Clicked Cancel", "Cancel Dialog Box",JOptionPane.WARNING_MESSAGE);
					}
					
				}

				private  void fileFilterDoc() {
					JFileChooser chooser = new JFileChooser();
					File file1 =new File("C:\\MAINPROJECT\\PROJECT1");
					File selectedFileNameDir, selectedFileNamePath;
					int Checker;
					chooser.setCurrentDirectory(file1);
					chooser.setFileSelectionMode(chooser.FILES_AND_DIRECTORIES);
					chooser.addChoosableFileFilter(new FileFilterprg("MS Office Documents", "docx"));
					chooser.addChoosableFileFilter(new FileFilterprg("MS Office Documents", "xlsx"));
					chooser.setAcceptAllFileFilterUsed(true);
					Checker =chooser.showOpenDialog(null);
					if(Checker ==JFileChooser.APPROVE_OPTION)
					{
						selectedFileNamePath = chooser.getCurrentDirectory();
						selectedFileNameDir = chooser.getSelectedFile();
						System.out.println("Selected file path  "+selectedFileNamePath.getAbsolutePath());
						System.out.println("selected file name"+selectedFileNameDir.getName());
					   
					   	 String name =chooser.getSelectedFile().getAbsolutePath();		
							try {
								FileWriter fw=new FileWriter(chooser.getSelectedFile());
								fw.write(name);
								fw.flush();
								fw.close();
								
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
					 
						
					}else
					{
						JOptionPane.showMessageDialog(null,"You have Clicked Cancel", "Cancel Dialog Box",JOptionPane.WARNING_MESSAGE);
					}
					
					
							}
		
		  });
	
	
SubProj1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			File file2= new File("C:\\MAINPROJECT\\PROJECT1\\PROJECTA");
			if(!file2.exists())
			{
				if(file2.mkdir())
				{
					System.out.println("PROJECT1 WITH SUB PROJECTA A GOT CREATED");
				}
				else
				{
					System.out.println("PROJECT1 WITH SUB PROJECTA A NOT CREATED");
				}	
				
			}
			
		}
		
		});
	
	Subproj2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			File file3= new File("C:\\MAINPROJECT\\PROJECT2");
			if(!file3.exists())
			{
				if(file3.mkdir())
				{
					System.out.println("PROJECT2  A GOT CREATED");
					 fileFilterDoc();
				}
				else
				{
					System.out.println("PROJECT2 A NOT CREATED");
				}	
				
			}
			
		}

		private void fileFilterDoc() {
			JFileChooser chooser = new JFileChooser();
			File file1 =new File("C:\\MAINPROJECT\\PROJECT2");
			File selectedFileNameDir, selectedFileNamePath;
			int Checker;
		
			chooser.setCurrentDirectory(file1);
			chooser.setFileSelectionMode(chooser.FILES_AND_DIRECTORIES);
			chooser.addChoosableFileFilter(new FileFilterprg("MS Office Documents", "docx"));
			chooser.addChoosableFileFilter(new FileFilterprg("MS Office Documents", "xlsx"));
			chooser.setAcceptAllFileFilterUsed(true);
			Checker =chooser.showOpenDialog(null);
			if(Checker ==JFileChooser.APPROVE_OPTION)
			{
				selectedFileNamePath = chooser.getCurrentDirectory();
				selectedFileNameDir = chooser.getSelectedFile();
				System.out.println("Selected file path  "+selectedFileNamePath.getAbsolutePath());
				System.out.println("selected file name"+selectedFileNameDir.getName());
				
				
						   
			   	 String name =chooser.getSelectedFile().getAbsolutePath();		
							
						if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
						  File file = chooser.getSelectedFile();
						  FileWriter fw;
						try {
							fw = new FileWriter(chooser.getSelectedFile());
							fw.write(name);
							fw.flush();
							fw.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
							
						 
						}
						
	
				
			}else
			{
				JOptionPane.showMessageDialog(null,"You have Clicked Cancel", "Cancel Dialog Box",JOptionPane.WARNING_MESSAGE);
			}
			
			
		}
		 
	});
	
	Subproj3.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			File file4= new File("C:\\MAINPROJECT\\PROJECT3");
			if(!file4.exists())
			{
				if(file4.mkdir())
				{
					System.out.println("PROJECT3 A GOT CREATED");
				}
				else
				{
					System.out.println("PROJECT3 A NOT CREATED");
				}	
				
			}
			
		
		File file5= new File("C:\\MAINPROJECT\\PROJECT3\\SUBPROJECT3");
		if(!file5.exists())
		{
			if(file5.mkdir())
			{
				System.out.println("SUBPROJECT3 A GOT CREATED");
			}
			else
			{
				System.out.println("SUBPROJECT3 A NOT CREATED");
			}	
			
		}
		
		}
	});
	
	
	
    
	
	}
	
	public static void main(String[] args)
	{
		CodeMenuSys();
		
	}
	
	
}
	
