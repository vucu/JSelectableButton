package view.template;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.JButton;

/*
 * @author Vu Cu
 */
public class JSelectableButton extends JButton {
	public JSelectableButton() {
		super();
		setSelected(false);
		addSelectedAction();
	}

	public JSelectableButton(Action a) {
		super(a);
		setSelected(false);
		addSelectedAction();
	}

	public JSelectableButton(Icon icon) {
		super(icon);
		setSelected(false);
		addSelectedAction();
	}

	public JSelectableButton(String text, Icon icon) {
		super(text, icon);
		setSelected(false);
		addSelectedAction();
	}

	public JSelectableButton(String text) {
		super(text);
		setSelected(false);
		addSelectedAction();
	}

	private void addSelectedAction() {
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (group==null) {
					setSelected(!isSelected());
				}
				else {
					for (Enumeration<AbstractButton> iter = group.getElements(); iter.hasMoreElements();) {
						AbstractButton button = iter.nextElement();
						button.setSelected(false);
					}
					setSelected(true);
				}
			}
		});
	}
	
	private void changeColor() {
		setOpaque(selected);
		setContentAreaFilled(selected);
		setBorderPainted(selected);
	}
	
	private boolean selected;
	
	@Override
	public boolean isSelected() {
		return selected;
	}
	
	@Override
	public void setSelected(boolean b) {
		selected = b;
		changeColor();
	}

	private ButtonGroup group = null;
	public void setGroup(ButtonGroup group) {
		this.group = group;
		group.add(this);
	}
	
}
