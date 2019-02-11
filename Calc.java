import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import java.text.DecimalFormat;

public class Calc
{
	
	protected Shell shell;
	private Text display;
	
	static double num1;
	static double num2;
	static double result;
	static String operations;
	static String answer;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			Calc window = new Calc();
			window.open();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open()
	{
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed())
		{
			if (!display.readAndDispatch())
			{
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents()
	{
		shell = new Shell();
		shell.setImage(SWTResourceManager.getImage("C:\\Users\\Anna\\Documents\\calcul8tor.png"));
		shell.setBackground(SWTResourceManager.getColor(119, 136, 153));
		shell.setSize(266, 414);
		shell.setText("Calcul8or");
		shell.setLayout(new GridLayout(3, false));
		
	  //row 1 content
		display = new Text(shell, SWT.BORDER | SWT.RIGHT);
		display.setBackground(SWTResourceManager.getColor(119, 136, 153));
		display.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		display.setFont(SWTResourceManager.getFont("Dubai Light", 22, SWT.NORMAL));
		GridData gd_display = new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1);
		gd_display.heightHint = 62;
		gd_display.widthHint = 189;
		display.setLayoutData(gd_display);
		
		//row 2 content
		Button clearButton = new Button(shell, SWT.NONE);
		clearButton.setForeground(SWTResourceManager.getColor(119, 136, 153));
		clearButton.setFont(SWTResourceManager.getFont("Dubai Light", 9, SWT.BOLD));
		GridData gd_clearButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_clearButton.widthHint = 47;
		clearButton.setLayoutData(gd_clearButton);
		clearButton.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseDown(MouseEvent e) 
			{
				display.setText("");
			}
		});
		clearButton.setText("C");
		
		Button delete = new Button(shell, SWT.NONE);
		delete.setForeground(SWTResourceManager.getColor(119, 136, 153));
		delete.setFont(SWTResourceManager.getFont("Dubai Light", 9, SWT.BOLD));
		delete.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseDown(MouseEvent e) 
			{
				String delete = "";
				
				if(display.getText().length() > 0)
				{
					StringBuilder strB = new StringBuilder(display.getText());
					strB.deleteCharAt(display.getText().length() - 1);
					delete = strB.toString();
					display.setText(delete);
				}
			}
		});
		GridData gd_delete = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_delete.widthHint = 90;
		delete.setLayoutData(gd_delete);
		delete.setText("<-");
		
		Button unary = new Button(shell, SWT.NONE);
		unary.setFont(SWTResourceManager.getFont("Dubai Light", 9, SWT.BOLD));
		unary.setForeground(SWTResourceManager.getColor(119, 136, 153));
		unary.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseDown(MouseEvent e) 
			{
				double ops = Double.parseDouble(String.valueOf(display.getText()));
				ops = ops * (-1);
				display.setText(String.valueOf(ops));
			}
		});
		GridData gd_unary = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_unary.widthHint = 91;
		unary.setLayoutData(gd_unary);
		unary.setText("+/-");
		
		//row 3 content
		Button additionButton = new Button(shell, SWT.NONE);
		additionButton.setFont(SWTResourceManager.getFont("Dubai Light", 9, SWT.BOLD));
		additionButton.setForeground(SWTResourceManager.getColor(119, 136, 153));
		additionButton.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseDown(MouseEvent e) 
			{
				num1 = Double.parseDouble(display.getText());
				display.setText("");
				operations = "+";
			}
		});
		additionButton.setToolTipText("addition ");
		GridData gd_additionButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_additionButton.widthHint = 47;
		additionButton.setLayoutData(gd_additionButton);
		additionButton.setText("+");
		
		Button number1 = new Button(shell, SWT.NONE);
		number1.setForeground(SWTResourceManager.getColor(119, 136, 153));
		number1.setFont(SWTResourceManager.getFont("Dubai Light", 9, SWT.BOLD));
		number1.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseDown(MouseEvent e) 
			{
				String EnterNumber = display.getText() + number1.getText();
				display.setText(EnterNumber);
			}
		});
		GridData gd_number1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_number1.widthHint = 90;
		number1.setLayoutData(gd_number1);
		number1.setText("1");
		
		Button number2 = new Button(shell, SWT.NONE);
		number2.setForeground(SWTResourceManager.getColor(119, 136, 153));
		number2.setFont(SWTResourceManager.getFont("Dubai", 9, SWT.BOLD));
		number2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) 
			{
				String EnterNumber = display.getText() + number2.getText();
				display.setText(EnterNumber);
			}
		});
		GridData gd_number2 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_number2.widthHint = 91;
		number2.setLayoutData(gd_number2);
		number2.setText("2");
		
		//row 4 content
		Button subtractionButton = new Button(shell, SWT.NONE);
		subtractionButton.setFont(SWTResourceManager.getFont("Dubai Light", 9, SWT.BOLD));
		subtractionButton.setForeground(SWTResourceManager.getColor(119, 136, 153));
		subtractionButton.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseDown(MouseEvent e) 
			{
				num1 = Double.parseDouble(display.getText());
				display.setText("");
				operations = "-";
			}
		});
		subtractionButton.setToolTipText("subtraction");
		GridData gd_subtractionButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_subtractionButton.widthHint = 47;
		subtractionButton.setLayoutData(gd_subtractionButton);
		subtractionButton.setText("-");
		
		Button number3 = new Button(shell, SWT.NONE);
		number3.setFont(SWTResourceManager.getFont("Dubai Light", 9, SWT.BOLD));
		number3.setForeground(SWTResourceManager.getColor(119, 136, 153));
		number3.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseDown(MouseEvent e) 
			{
				String EnterNumber = display.getText() + number3.getText();
				display.setText(EnterNumber);
			}
		});
		GridData gd_number3 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_number3.widthHint = 89;
		number3.setLayoutData(gd_number3);
		number3.setText("3");
		
		Button number4 = new Button(shell, SWT.NONE);
		number4.setForeground(SWTResourceManager.getColor(119, 136, 153));
		number4.setFont(SWTResourceManager.getFont("Dubai Light", 9, SWT.BOLD));
		number4.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseDown(MouseEvent e) 
			{
				String EnterNumber = display.getText() + number4.getText();
				display.setText(EnterNumber);
			}
		});
		GridData gd_number4 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_number4.widthHint = 91;
		number4.setLayoutData(gd_number4);
		number4.setText("4");
		
		//row 5 content
		Button divisionButton = new Button(shell, SWT.NONE);
		divisionButton.setForeground(SWTResourceManager.getColor(119, 136, 153));
		divisionButton.setFont(SWTResourceManager.getFont("Dubai Light", 9, SWT.BOLD));
		divisionButton.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseDown(MouseEvent e) 
			{
				num1 = Double.parseDouble(display.getText());
				display.setText("");
				operations = "/";
			}
		});
		divisionButton.setToolTipText("division ");
		GridData gd_divisionButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_divisionButton.widthHint = 47;
		divisionButton.setLayoutData(gd_divisionButton);
		divisionButton.setText("/");
		
		Button number5 = new Button(shell, SWT.NONE);
		number5.setForeground(SWTResourceManager.getColor(119, 136, 153));
		number5.setFont(SWTResourceManager.getFont("Dubai Light", 9, SWT.BOLD));
		number5.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseDown(MouseEvent e) 
			{
				String EnterNumber = display.getText() + number5.getText();
				display.setText(EnterNumber);
			}
		});
		GridData gd_number5 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_number5.widthHint = 90;
		number5.setLayoutData(gd_number5);
		number5.setText("5");
		
		Button number6 = new Button(shell, SWT.NONE);
		number6.setFont(SWTResourceManager.getFont("Dubai Light", 9, SWT.BOLD));
		number6.setForeground(SWTResourceManager.getColor(119, 136, 153));
		number6.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseDown(MouseEvent e) 
			{
				String EnterNumber = display.getText() + number6.getText();
				display.setText(EnterNumber);
			}
		});
		GridData gd_number6 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_number6.widthHint = 92;
		number6.setLayoutData(gd_number6);
		number6.setText("6");
		
		//row 6 content
		Button multipicationButton = new Button(shell, SWT.NONE);
		multipicationButton.setForeground(SWTResourceManager.getColor(119, 136, 153));
		multipicationButton.setFont(SWTResourceManager.getFont("Dubai Light", 9, SWT.BOLD));
		multipicationButton.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseDown(MouseEvent e) 
			{
				num1 = Double.parseDouble(display.getText());
				display.setText("");
				operations = "*";
			}
		});
		multipicationButton.setToolTipText("multipication");
		GridData gd_multipicationButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_multipicationButton.widthHint = 47;
		multipicationButton.setLayoutData(gd_multipicationButton);
		multipicationButton.setText("*");
		
		Button number7 = new Button(shell, SWT.NONE);
		number7.setForeground(SWTResourceManager.getColor(119, 136, 153));
		number7.setFont(SWTResourceManager.getFont("Dubai Light", 9, SWT.BOLD));
		number7.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseDown(MouseEvent e) 
			{
				String EnterNumber = display.getText() + number7.getText();
				display.setText(EnterNumber);
			}
		});
		GridData gd_number7 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_number7.widthHint = 89;
		number7.setLayoutData(gd_number7);
		number7.setText("7");
		
		Button number8 = new Button(shell, SWT.NONE);
		number8.setForeground(SWTResourceManager.getColor(119, 136, 153));
		number8.setFont(SWTResourceManager.getFont("Dubai Light", 9, SWT.BOLD));
		number8.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseDown(MouseEvent e) 
			{
				String EnterNumber = display.getText() + number8.getText();
				display.setText(EnterNumber);
			}
		});
		GridData gd_number8 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_number8.widthHint = 92;
		number8.setLayoutData(gd_number8);
		number8.setText("8");
		
		//row 7 content
		Button modulusButton = new Button(shell, SWT.NONE);
		modulusButton.setForeground(SWTResourceManager.getColor(119, 136, 153));
		modulusButton.setFont(SWTResourceManager.getFont("Dubai Light", 9, SWT.BOLD));
		modulusButton.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseDown(MouseEvent e) 
			{
				num1 = Double.parseDouble(display.getText());
				display.setText("");
				operations = "%";
			}
		});
		modulusButton.setToolTipText("modulus");
		GridData gd_modulusButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_modulusButton.widthHint = 47;
		modulusButton.setLayoutData(gd_modulusButton);
		modulusButton.setText("%");
		
		Button number9 = new Button(shell, SWT.NONE);
		number9.setForeground(SWTResourceManager.getColor(119, 136, 153));
		number9.setFont(SWTResourceManager.getFont("Dubai Light", 9, SWT.BOLD));
		number9.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseDown(MouseEvent e) 
			{
				String EnterNumber = display.getText() + number9.getText();
				display.setText(EnterNumber);
			}
		});
		GridData gd_number9 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_number9.widthHint = 88;
		number9.setLayoutData(gd_number9);
		number9.setText("9");
		
		Button number0 = new Button(shell, SWT.NONE);
		number0.setFont(SWTResourceManager.getFont("Dubai Light", 9, SWT.BOLD));
		number0.setForeground(SWTResourceManager.getColor(119, 136, 153));
		number0.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseDown(MouseEvent e) 
			{
				String EnterNumber = display.getText() + number0.getText();
				display.setText(EnterNumber);
			}
		});
		GridData gd_number0 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_number0.widthHint = 93;
		number0.setLayoutData(gd_number0);
		number0.setText("0");
		
		Button decimal = new Button(shell, SWT.NONE);
		decimal.setForeground(SWTResourceManager.getColor(119, 136, 153));
		decimal.setFont(SWTResourceManager.getFont("Dubai Light", 9, SWT.BOLD));
		decimal.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseDown(MouseEvent e) 
			{
				String EnterNumber = display.getText() + decimal.getText();
				display.setText(EnterNumber);
			}
		});
		GridData gd_decimal = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_decimal.heightHint = 40;
		gd_decimal.widthHint = 47;
		decimal.setLayoutData(gd_decimal);
		decimal.setText(".");
		
		//row 8 content
		Button equalsButton = new Button(shell, SWT.NONE);
		equalsButton.setFont(SWTResourceManager.getFont("Dubai Light", 11, SWT.BOLD));
		equalsButton.setForeground(SWTResourceManager.getColor(119, 136, 153));
		equalsButton.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseDown(MouseEvent e)
			{
				String answer;
				num2 = Double.parseDouble(display.getText());
				
				if (operations == "+")
				{
					result = num1 + num2;
					answer = String.format("%.2f", result);
					display.setText(answer);
				}
				else if (operations == "-")
				{
					result = num1 - num2;
					answer = String.format("%.2f", result);
					display.setText(answer);
				}
				else if (operations == "*")
				{
					result = num1 * num2;
					answer = String.format("%.2f", result);
					display.setText(answer);
				}
				else if (operations == "/")
				{
					result = num1 / num2;
					answer = String.format("%.2f", result);
					display.setText(answer);
				}
				else if (operations == "%")
				{
					result = num1 % num2;
					answer = String.format("%.2f", result);
					display.setText(answer);
				}
			}
		});
		equalsButton.setToolTipText("equals");
		GridData gd_equalsButton = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		gd_equalsButton.heightHint = 55;
		gd_equalsButton.widthHint = 186;
		equalsButton.setLayoutData(gd_equalsButton);
		equalsButton.setText("=");

	}

}
