/** Generated by YAKINDU Statechart Tools code generator. */
package hu.bme.mit.inf.symod.fm652.homework.chessclock;

import hu.bme.mit.inf.symod.fm652.homework.IStatemachine;
import hu.bme.mit.inf.symod.fm652.homework.ITimerCallback;

public interface IChessClockStatemachine extends ITimerCallback,IStatemachine {
	public interface SCIButtons {
	
		public void raiseModeButton();
		
		public void raiseStartButton();
		
		public void raiseBlackButton();
		
		public void raiseWhiteButton();
		
	}
	
	public SCIButtons getSCIButtons();
	
	public interface SCIBeeper {
	
		public void setSCIBeeperOperationCallback(SCIBeeperOperationCallback operationCallback);
	
	}
	
	public interface SCIBeeperOperationCallback {
	
		public void beep();
		
	}
	
	public SCIBeeper getSCIBeeper();
	
	public interface SCIDisplay {
	
		public String getText();
		
		public void setText(String value);
		
		public long getWhiteDisplay();
		
		public void setWhiteDisplay(long value);
		
		public long getBlackDisplay();
		
		public void setBlackDisplay(long value);
		
	}
	
	public SCIDisplay getSCIDisplay();
	
}
