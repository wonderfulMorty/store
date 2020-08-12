package start;


import jframe.loginJFrame;

public class start {
	public static void main(String[] args) {
		 try
		    {
		        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		    }
		    catch(Exception e)
		    {
		        //TODO exception
		    }
    	loginJFrame log =new loginJFrame();
    	log.setVisible(true);
	}
}
