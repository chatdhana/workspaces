package com.virtusa.placement.model;

import com.virtusa.placement.controller.*;

import java.util.ArrayList;
import java.util.List;

public class MaxExpChooserRecBiz {
	private List maxExp; 
	
	public MaxExpChooserRec expChooser(MaxExpChooserRec mecr)
	{	
		int i;
		maxExp=new ArrayList();
		i=new Integer(mecr.getMinExpT()).intValue();
		for(i=(i>-1)?i:++i;i>=0&&i<=30;i++)
			maxExp.add(i);
		mecr.setMaxExp(maxExp);
		
		return mecr;
	}
	
}
