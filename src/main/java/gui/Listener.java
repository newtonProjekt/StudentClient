package gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;

public class Listener {
	CheckBox[] cb;
	
	int index=-1;
	
	public Listener(CheckBox[] cb) {
		this.cb = cb;
		for(int x=0; x<cb.length;x++) {
			cb[x].selectedProperty().addListener (new ChangeListener<Boolean>() {

				@Override
				public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) {
					if(cb)
					
				}
               
			
		});
	}

	}
}
