package advanced;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class PersonFileFilter extends FileFilter {

	public boolean accept(File f) {
		//String file=f.getName();
		String extention="";
		if(Utility.getExtension(f)!="")
		{ extention=Utility.getExtension(f);}
		
		 
		 
		if(f.isDirectory())
		{return true;}
		if(extention.equals(""))
		{return false;}
		if(extention.equals("jpeg"))
		{return true ;}
		if(extention.equals(null))
		{return false;}
		
		
		return false;
		
	}

	public String getDescription() {
		
		return "person database filter(*.jpeg)";
	}

	
	
}
