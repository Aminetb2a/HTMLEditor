package HtmlEditor;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.Element;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

public class HtmlEdit extends JFrame {

    public JTextArea txtArea;
    public JTextArea Line;
    public JEditorPane labl;
    public int fontSize = 12;
    public String filePath = new String();
    public UndoManager undoManager = new UndoManager();

    public ImageIcon Nw= new ImageIcon("images/fs-plus.png");
    private ImageIcon Op= new ImageIcon("images/fs-folder_1.png");
    private ImageIcon Und= new ImageIcon("images/fs-mail.png");
    private ImageIcon Rdo= new ImageIcon("images/fs-mail_1.png");
    private ImageIcon Sv= new ImageIcon("images/fs-save.png");
    private ImageIcon SvAs= new ImageIcon("images/fs-saveas.png");
    private ImageIcon Ext= new ImageIcon("images/fs-power.png");
    private ImageIcon Cutt =new ImageIcon("images/fs-scissors.png");
    private ImageIcon Pastt =new ImageIcon("images/fs-paste.png");
    private ImageIcon copy =new ImageIcon("images/fs-copy.png");
    private ImageIcon Rune =new ImageIcon("images/fs-code.png");
    private ImageIcon select =new ImageIcon("images/fs-file.png");
    private ImageIcon bold =new ImageIcon("images/fs-bold.png");
    private ImageIcon italic =new ImageIcon("images/fs-italic.png");
    private ImageIcon under =new ImageIcon("images/fs-underline.png");
    private ImageIcon alLeft =new ImageIcon("images/fs-align_2.png");
    private ImageIcon alRight =new ImageIcon("images/fs-align_3.png");
    private ImageIcon alJustify =new ImageIcon("images/fs-align_1.png");
    private ImageIcon alCenter =new ImageIcon("images/fs-align.png");
    private ImageIcon Image =new ImageIcon("images/fs-image.png");
    private ImageIcon linkImage = new ImageIcon("images/fs-chain.png");
    private ImageIcon linkImage2 = new ImageIcon("images/fs-unlink.png");
    private ImageIcon desktop = new ImageIcon("images/fs-desktop.png");
    private ImageIcon zoomin = new ImageIcon("images/fs-search.png");
    private ImageIcon zoomout = new ImageIcon("images/fs-search_1.png");
// This class open files
    class OpeningFile implements ActionListener {

        public OpeningFile() {
        }

        public void actionPerformed(ActionEvent e) {

            JFileChooser file = new JFileChooser();
            file.showOpenDialog(null);
            File selectedFile = file.getSelectedFile();
            String fileName = selectedFile.getAbsolutePath();
            String filePth = new String();
            filePth = selectedFile.getParent();
            System.out.print(filePth);
            System.out.print(fileName);
            filePath = fileName;
            HtmlEdit ExMainFrame = new HtmlEdit();

            Object[] options = {"This Window",
                    "New Window",
                    "Cancel"};
            int Options = JOptionPane.showOptionDialog(ExMainFrame,
                    "New projects can either be opened in a new window or replace the project in the existing window. \n " +
                            "  How would you like to open the project ? ",
                    "Warning",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[2]);
            if (Options == 0) {

                try {
                    FileReader reader = new FileReader(fileName);
                    BufferedReader Bfr = new BufferedReader(reader);
                    txtArea.read(Bfr, null);
                    Bfr.close();

                    txtArea.getDocument().addUndoableEditListener(
                            new UndoableEditListener() {
                                public void undoableEditHappened(UndoableEditEvent e) {
                                    undoManager.addEdit(e.getEdit());

                                }
                            });
                    //add number lines
                    txtArea.getDocument().addDocumentListener(new DocumentListener() {
                        public String getText() {
                            int caretPosition = txtArea.getDocument().getLength();
                            Element root = txtArea.getDocument().getDefaultRootElement();
                            String text = "1    " + System.getProperty("line.separator");
                            for (int i = 2; i < root.getElementIndex(caretPosition) + 2; i++) {
                                text += i + "     " + System.getProperty("line.separator");
                            }
                            return text;
                        }

                        @Override
                        public void changedUpdate(DocumentEvent de) {
                            Line.setText(getText() + "  ");
                        }

                        @Override
                        public void insertUpdate(DocumentEvent de) {
                            Line.setText(getText() + "  ");
                        }

                        @Override
                        public void removeUpdate(DocumentEvent de) {
                            Line.setText(getText() + "  ");
                        }

                    });
                    txtArea.append(" ");
                    setTitle("Html Editor /" + fileName);
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(null, exc);
                }
            }

            if (Options == 1){

                HtmlEdit ExMainFrame1 = new HtmlEdit();
                ExMainFrame1.setLocale(null);
                ExMainFrame1.dispose();
                ExMainFrame1.setVisible(true);
                ExMainFrame1.pack();
                ExMainFrame1.filePath = fileName;
                try {
                    FileReader reader = new FileReader(fileName);
                    BufferedReader Bfr = new BufferedReader(reader);
                    ExMainFrame1.txtArea.read(Bfr, null);
                    Bfr.close();

                    ExMainFrame1.txtArea.getDocument().addUndoableEditListener(
                            new UndoableEditListener() {
                                public void undoableEditHappened(UndoableEditEvent e) {
                                    undoManager.addEdit(e.getEdit());

                                }
                            });
                    //add number lines
                    ExMainFrame1.txtArea.getDocument().addDocumentListener(new DocumentListener() {
                        public String getText() {
                            int caretPosition = txtArea.getDocument().getLength();
                            Element root = txtArea.getDocument().getDefaultRootElement();
                            String text = "1    " + System.getProperty("line.separator");
                            for (int i = 2; i < root.getElementIndex(caretPosition) + 2; i++) {
                                text += i + "     " + System.getProperty("line.separator");
                            }
                            return text;
                        }

                        @Override
                        public void changedUpdate(DocumentEvent de) {
                            Line.setText(getText() + "  ");
                        }

                        @Override
                        public void insertUpdate(DocumentEvent de) {
                            Line.setText(getText() + "  ");
                        }

                        @Override
                        public void removeUpdate(DocumentEvent de) {
                            Line.setText(getText() + "  ");
                        }
                    });
                    ExMainFrame1.txtArea.append(" ");
                    ExMainFrame1.setTitle("Html Editor /" + fileName);

                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(null, exc);
                }
            }
        }
    }

// This class Saves Files As...
    class savingAS implements ActionListener {

        public savingAS(){}

        public void actionPerformed(ActionEvent ae)
        {
            try
            {
                String s=txtArea.getText();

                    FileDialog fd= new FileDialog(new HtmlEdit(),"Save File As",FileDialog.SAVE);
                    fd.setFile("untitled.html");
                    fd.setVisible(true);
                    String path=fd.getDirectory()+fd.getFile();

                    FileOutputStream fos=new FileOutputStream(path);
                    System.out.println(s);
                    byte[] b=s.getBytes();
                    fos.write(b);
                    fos.close();

            }catch(Exception e){System.out.println(e);}
        }
    }

// This Class Saves Files
class savingFile implements ActionListener {

    public savingFile() {}

    public void actionPerformed(ActionEvent ae) {
        String txtAreaContnet = txtArea.getText();
        File file = new File(filePath);
        FileDialog fDialogue = new FileDialog(new HtmlEdit(), "Save File As", FileDialog.SAVE);

        if (file.isFile() && file.canRead()) {
            try {

                FileOutputStream fileOut = new FileOutputStream(filePath);
                byte[] content = txtAreaContnet.getBytes();
                fileOut.write(content);
                fileOut.close();

            } catch (Exception e) {
                System.out.println(e);
            }
        } else {

            try {

                fDialogue.setDirectory("C:/Projects");
                fDialogue.setFile("untitled.html");
                fDialogue.setVisible(true);
                String path = fDialogue.getDirectory() + fDialogue.getFile();
                filePath = path;
                FileOutputStream fileOut = new FileOutputStream(path);
                byte[] content = txtAreaContnet.getBytes();
                fileOut.write(content);
                fileOut.close();
                if (fDialogue.getFile() != null){
                    setTitle("Html Editor...."+"/" + fDialogue.getFile());

                }
                Tree t = new Tree();
                t.updateFiles();

            } catch (Exception e) {
                System.out.println(e);
            }
            Tree t = new Tree();
            t.updateFiles();
        }
        if (fDialogue.getDirectory() == null && fDialogue.getFile()==null){
            filePath=new String();
        }
    }
}

// This Class Adds href Links
    class AddHRef extends JFrame {

        private JTextArea linkUrl = new JTextArea(4, 38);
        private JTextField linkTitle = new JTextField(38);
        private JComboBox target = new JComboBox(new String[]{"Default Page", "Same Frame", "Whole Page", "New Browser", "Parent Frame"});
        private JLabel Linkurl = new JLabel(linkImage2);
        private JLabel LinkTitle = new JLabel("Link Title");
        private JLabel Target = new JLabel("Target");
        final JScrollPane linkScroll = new JScrollPane(linkUrl);
        private JPanel pLink = new JPanel();
        private JButton addLink = new JButton("Add");
        private String select = new String();

        HtmlEdit caller;

        public AddHRef(final HtmlEdit caller) {
            pLink.setLayout(null);
            this.caller = caller;
            linkUrl.setLineWrap(true);

                addLink.addActionListener(new ActionListener() {
                private String addLink = new String();

                @Override
                public void actionPerformed(ActionEvent e) {

                    if (linkUrl.getText() != null)
                        addLink = "<a href=\"" + linkUrl.getText();
                    else
                        addLink = "<a href=\"";

                    if (target.getSelectedItem() == "Default Page")
                        addLink = addLink + "\" target=\"" + " title";
                    else if (target.getSelectedItem() == "Same Frame")
                        addLink = addLink + "\" target=\"_self\" title=\"";
                    else if (target.getSelectedItem() == "Whole Page")
                        addLink = addLink + "\" target=\"_top\" title=\"";
                    else if (target.getSelectedItem() == "New Browser")
                        addLink = addLink + "\" target=\"_blank\" title=\"";
                    else
                        addLink = addLink + "\" target=\"_parent\" title=\"";

                    if (linkTitle.getText() != null)
                        addLink = addLink + linkTitle.getText() + "\">";
                    else
                        addLink = addLink + "\">";
                    if (select != null)
                        addLink = addLink + select + "</a>";
                    else
                        addLink = addLink + "</a>";
                    caller.insertToTextArea(addLink);
                    setVisible(false);
                }
            });

            LinkTitle.setBounds(20, 10, 100, 60);
            pLink.add(LinkTitle);
            linkTitle.setBounds(70, 30, 390, 20);
            pLink.add(linkTitle);
            Linkurl.setBounds(20, 60, 30, 30);
            pLink.add(Linkurl);
            linkScroll.setBounds(70, 60, 390, 40);
            pLink.add(linkScroll);
            Target.setBounds(20, 110, 50, 30);
            pLink.add(Target);
            target.setBounds(70, 115, 100, 20);
            pLink.add(target);
            addLink.setBounds(410, 140, 60, 20);
            pLink.add(addLink);
            add(pLink, BorderLayout.CENTER);
        }

        public void getSelected(String select) {
            this.select = select;
        }
    }

// This Class implements Undo Action
    class UndoAction implements ActionListener {

        public UndoAction() {}

        public void actionPerformed(ActionEvent e) {
            try {
                undoManager.undo();
            } catch (Exception ex) {
            }
        }
    }

// This Class implements Redo Action
    class RedoAction implements ActionListener{
        public RedoAction() {}

        public void actionPerformed(ActionEvent e) {
            try {
                undoManager.redo();
            } catch (Exception ex) {
            }
        }
    }

// This Class implements Cut Action
    class CutAction implements ActionListener{
        public CutAction(){}

        public void actionPerformed(ActionEvent le) {
            txtArea.cut();
        }
    }

    // This Class implements Copy Action
    class CopyAction implements ActionListener{
        public CopyAction(){}

        public void actionPerformed(ActionEvent le) {
            txtArea.copy();
        }
    }

    // This Class implements Paste Action
    class PastAction implements ActionListener{
        public PastAction(){}

        public void actionPerformed(ActionEvent le) {
            txtArea.paste();
        }
    }

    // This Class implements Select Action
    class SelectAction implements ActionListener{
        public SelectAction(){}

        public void actionPerformed(ActionEvent le) {
            txtArea.selectAll();
        }
    }

    // This Class implements Bold Action
    class BoldAction implements ActionListener{
        public BoldAction(){}

        public void actionPerformed(ActionEvent e) {
            String Bold = new String();
            if (txtArea.getSelectedText()!=null) {
                Bold = "<b>" + txtArea.getSelectedText() + "</b>";
                txtArea.replaceSelection(Bold);
            }
            else {
                Bold = "<b>" +"</b>";
                txtArea.replaceSelection(Bold);
            }
        }
    }

    // This Class implements Italic Action
    class ItalicAction implements ActionListener{
        public ItalicAction(){}

        public void actionPerformed(ActionEvent e) {
            String Italic = new String();
            if (txtArea.getSelectedText()!=null) {
                Italic = "<i>" + txtArea.getSelectedText() + "</i>";
                txtArea.replaceSelection(Italic);
            }
            else{
                Italic = "<i>" +"</i>";
                txtArea.replaceSelection(Italic);
            }
        }
    }

    // This Class implements Under Action
    class UnderAction implements ActionListener{
        public UnderAction(){}

        public void actionPerformed(ActionEvent e) {
            String Under = new String();
            if (txtArea.getSelectedText()!=null) {
                Under = "<u>" + txtArea.getSelectedText() + "</u>";
                txtArea.replaceSelection(Under);
            }
            else{
                Under = "<u>" +"</u>";
                txtArea.replaceSelection(Under);
            }
        }
    }

// This Class implements Zoom In Action
    class ZoomINText implements ActionListener {
        public ZoomINText(){}
        public void actionPerformed(ActionEvent e) {

            if (fontSize < 17) {
                fontSize += 1;
                Font font = new Font("Verdana", Font.HANGING_BASELINE, fontSize);
                txtArea.setFont(font);
                Line.setFont(font);
            }
        }
    }

    // This Class implements Zoom Out Action
    class ZoomOutText implements ActionListener {
        public ZoomOutText(){}
        public void actionPerformed(ActionEvent e) {
            if (fontSize>12) {
                fontSize -= 1;
                Font font = new Font("Verdana", Font.HANGING_BASELINE, fontSize);
                txtArea.setFont(font);
                Line.setFont(font);
            }
        }
    }

    // This Class Create a Menu Bar
    class Menu extends JMenuBar{

        public Menu(){
            final JMenu File,Edit,View,txtEdit,Runn;
            JMenuItem Open,Save,SaveAs,Exit,NewFile,Cut,Copy,Paste,Select,Undo,Redo,Bold,Italic,Under,Zoomin,Zoomout,Run;

            File = new JMenu("File     ");
            Edit = new JMenu("Edit     ");
            View = new JMenu("View     ");
            Runn = new JMenu("Run     ");
            txtEdit = new JMenu("Text Editing...     ");

            NewFile = new JMenuItem("File",Nw);
            NewFile.addActionListener(new NewAction());
            NewFile.setIconTextGap(10);
            NewFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
                    Event.CTRL_MASK));

            Save = new JMenuItem("Save ",Sv);
            Save.setIconTextGap(10);
            Save.addActionListener(new savingFile());
            Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                    Event.CTRL_MASK));

            SaveAs = new JMenuItem("Save As ",SvAs);
            SaveAs.setIconTextGap(10);
            SaveAs.addActionListener(new savingAS());
            SaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                    KeyEvent.CTRL_MASK + KeyEvent.SHIFT_MASK));

            Exit = new JMenuItem("Exit ",Ext);
            Exit.setIconTextGap(10);
            Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
                    KeyEvent.CTRL_MASK));
            Exit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String ObjButtons[] = {"Exit","No "};
                    int PromptResult = JOptionPane.showOptionDialog(null,
                            "Are You Sure You Want To Exit ?! ", "Comfirm Exit !",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
                            ObjButtons, ObjButtons[1]);
                    if (PromptResult == 0) {
                        dispose();
                    }

                }
            });

            Open = new JMenuItem("Open...     ",Op);
            Open.setIconTextGap(10);
            Open.addActionListener(new OpeningFile());
            Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
                    Event.CTRL_MASK));

            Cut = new JMenuItem("Cut ",Cutt);
            Cut.setIconTextGap(10);
            Cut.addActionListener(new CutAction());
            Cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
                    Event.CTRL_MASK));


            Copy = new JMenuItem("Copy ",copy);
            Copy.setIconTextGap(10);
            Copy.addActionListener(new CopyAction());
            Copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
                    Event.CTRL_MASK));

            Paste = new JMenuItem("Paste ",Pastt);
            Paste.setIconTextGap(10);
            Paste.addActionListener(new PastAction());
            Paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
                    Event.CTRL_MASK));

            Select = new JMenuItem("Select All  ",select);
            Select.setIconTextGap(10);
            Select.addActionListener(new SelectAction());
            Select.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
                    Event.CTRL_MASK));

            Undo = new JMenuItem("Undo ",Und);
            Undo.setIconTextGap(10);
            Undo.addActionListener(new UndoAction());
            Undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,
                    Event.CTRL_MASK));

            Redo = new JMenuItem("Redo ",Rdo);
            Redo.setIconTextGap(10);
            Redo.addActionListener(new RedoAction());
            Redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,
                    Event.CTRL_MASK));

            Bold = new JMenuItem("Bold ",bold);
            Bold.addActionListener(new BoldAction());
            Bold.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,
                    Event.CTRL_MASK));

            Italic = new JMenuItem("Italic ",italic);
            Italic.addActionListener(new ItalicAction());
            Italic.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,
                    Event.CTRL_MASK));

            Under = new JMenuItem("Under ",under);
            Under.addActionListener(new UnderAction());
            Under.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,
                    Event.CTRL_MASK));

            Zoomin = new JMenuItem("Zoom In ",zoomin);
            Zoomin.addActionListener(new ZoomINText());
            Zoomin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
                    Event.CTRL_MASK));

            Zoomout = new JMenuItem("Zoom Out ",zoomout);
            Zoomout.addActionListener(new ZoomOutText());
            Zoomout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,
                    Event.CTRL_MASK));

            Run = new JMenuItem("Run ",Rune);
            Run.addActionListener(new RunBtn());
            Run.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
                    Event.CTRL_MASK));


            File.add(NewFile);
            File.add(Open);
            File.add(new JSeparator());
            File.add(Save);
            File.add(SaveAs);
            File.add(new JSeparator());
            File.add(Exit);


            txtEdit.add(Bold);
            txtEdit.add(Italic);
            txtEdit.add(Under);

            Edit.add(Undo);
            Edit.add(Redo);
            Edit.add(new JSeparator());
            Edit.add(Cut);
            Edit.add(Paste);
            Edit.add(Copy);
            Edit.add(new JSeparator());
            Edit.add(Select);
            Edit.add(txtEdit);

            View.add(Zoomin);
            View.add(Zoomout);

            Runn.add(Run);

            add(File);
            add(Edit);
            add(View);
            add(Runn);
        }
    }

    //This Class Customize the Tool Tip Text
    class CustomJToolTip extends JToolTip {

        public CustomJToolTip(JComponent component) {
            super();
            setComponent(component);
            setBackground(Color.WHITE);
            setForeground(Color.DARK_GRAY);
        }
    }

    //This Class Create a Tool Bar
    class ToolBar extends JToolBar{

        public ToolBar(){

            setFloatable(false);
            setForeground(Color.black);
            Border emptyBorder = BorderFactory.createEmptyBorder(0,2,0,2);


            JButton New =new JButton(Nw){
                @Override
                public JToolTip createToolTip() {
                    return (new CustomJToolTip(this));
                }
            };
            New.addActionListener(new NewAction());
            New.setToolTipText("New     Ctrl + N ");
            New.setBorder(emptyBorder);


            JButton open =new JButton(Op);
            open.setBorder(emptyBorder);
            open.addActionListener(new OpeningFile());
            open.setToolTipText("Open          Ctrl + O ");

            JButton save =new JButton(Sv);
            save.setBorder(emptyBorder);
            save.addActionListener(new savingFile());
            save.setToolTipText("Save          Ctrl + S ");

            JButton saveAs =new JButton(SvAs);
            saveAs.setBorder(emptyBorder);
            saveAs.addActionListener(new savingFile());
            saveAs.setToolTipText("Save As    Shift + Ctrl + S ");

            undoManager = new UndoManager();
            JButton Undo =new JButton(Und);
            Undo.addActionListener(new UndoAction());
            Undo.setBorder(emptyBorder);
            Undo.setToolTipText("Back     Ctrl + Z ");

            JButton Redo =new JButton(Rdo);
            Redo.addActionListener(new RedoAction());
            Redo.setBorder(emptyBorder);
            Redo.setToolTipText("Forward     Ctrl + Y ");

            JButton Cut =new JButton(Cutt);
            Cut.addActionListener(new CutAction());
            Cut.setBorder(emptyBorder);
            Cut.setToolTipText("Cut     Ctrl + X ");

            JButton Paste =new JButton(Pastt);
            Paste.addActionListener(new PastAction());
            Paste.setBorder(emptyBorder);
            Paste.setToolTipText("Paste     Ctrl + V ");

            JButton Copy =new JButton(copy);
            Copy.addActionListener(new CopyAction());
            Copy.setBorder(emptyBorder);
            Copy.setToolTipText("Copy     Ctrl + C ");

            JButton Bold =new JButton(bold);
            Bold.setBorder(emptyBorder);
            Bold.addActionListener(new BoldAction());
            Bold.setToolTipText("Bold     Ctrl + B ");

            JButton Italic =new JButton(italic);
            Italic.setBorder(emptyBorder);
            Italic.addActionListener(new ItalicAction());
            Italic.setToolTipText("Italic     Ctrl + I ");

            JButton Under =new JButton(under);
            Under.setBorder(emptyBorder);
            Under.addActionListener(new UnderAction());
            Under.setToolTipText("Under     Ctrl + U ");

            JButton alleft =new JButton(alLeft);
            alleft.setBorder(emptyBorder);
            alleft.setToolTipText("Left  ");
            alleft.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String Alignment = new String();
                    if (txtArea.getSelectedText() != null) {
                        Alignment = "<div align=\"left\">" + txtArea.getSelectedText() + "</div>";
                        txtArea.replaceSelection(Alignment);
                    } else {
                        Alignment = "<div align=\"left\">" + "</div>";
                        txtArea.replaceSelection(Alignment);
                    }
                }
            });

            JButton alcenter =new JButton(alCenter);
            alcenter.setBorder(emptyBorder);
            alcenter.setToolTipText("Center ");
            alcenter.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String Alignment = new String();
                    if (txtArea.getSelectedText() != null) {
                        Alignment = "<div align=\"center\">" + txtArea.getSelectedText() + "</div>";
                        txtArea.replaceSelection(Alignment);
                    } else {
                        Alignment = "<div align=\"center\">" + "</div>";
                        txtArea.replaceSelection(Alignment);
                    }
                }
            });



            JButton aljustify =new JButton(alJustify);
            aljustify.setBorder(emptyBorder);
            aljustify.setToolTipText("Justify ");
            aljustify.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String Alignment = new String();
                    if (txtArea.getSelectedText() != null) {
                        Alignment = "<div align=\"justify\">" + txtArea.getSelectedText() + "</div>";
                        txtArea.replaceSelection(Alignment);
                    } else {
                        Alignment = "<div align=\"justify\">" + "</div>";
                        txtArea.replaceSelection(Alignment);
                    }
                }
            });

            JButton alright =new JButton(alRight);
            alright.setBorder(emptyBorder);
            alright.setToolTipText("Right ");
            alright.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String Alignment = new String();
                    if (txtArea.getSelectedText() != null) {
                        Alignment = "<div align=\"right\">" + txtArea.getSelectedText() + "</div>";
                        txtArea.replaceSelection(Alignment);
                    } else {
                        Alignment = "<div align=\"right\">" + "</div>";
                        txtArea.replaceSelection(Alignment);
                    }
                }
            });

            // adding image
            final JButton btnAddImage = new JButton(Image);
            btnAddImage.setBorder(emptyBorder);
            btnAddImage.setToolTipText("Add Image ");
            btnAddImage.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    AddImage te = new AddImage(HtmlEdit.this);
                    te.pack();
                    te.setTitle("Add Image");
                    te.setVisible(true);
                    te.setSize(500, 260);
                    te.setResizable(false);
                    te.setLocationRelativeTo(null);
                }
            });


            //adding link href
            final JButton btnAddLink = new JButton(linkImage);
            btnAddLink.setBorder(emptyBorder);
            btnAddLink.setToolTipText("Add Link");
            btnAddLink.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AddHRef addLink = new AddHRef(HtmlEdit.this);
                    addLink.getSelected(txtArea.getSelectedText());
                    addLink.pack();
                    addLink.setTitle("Add Link");
                    addLink.setVisible(true);
                    addLink.setSize(500, 200);
                    addLink.setResizable(false);
                    addLink.setLocationRelativeTo(null);
                }
            });


            //font size
            final JComboBox fontSize = new JComboBox(new String[]{"  Font Size 1","  Font Size 2","  Font Size 3","  Font Size 4","  Font Size 5","  Font Size 6","  Font Size 7"});
            fontSize.setMinimumSize(new Dimension(80, 28));
            fontSize.setBorder(emptyBorder);
            fontSize.setToolTipText("Font Size ");
            fontSize.setMaximumSize(new Dimension(100, 28));
            fontSize.addActionListener(new ActionListener() {
                String FontS = new String();

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (fontSize.getSelectedItem() == "  Font Size 1")
                        FontS = "<font size=\"1\">" + txtArea.getSelectedText() + "</font>";
                    else if (fontSize.getSelectedItem() == "  Font Size 2")
                        FontS = "<font size=\"2\">" + txtArea.getSelectedText() + "</font>";
                    else if (fontSize.getSelectedItem() == "  Font Size 3")
                        FontS = "<font size=\"3\">" + txtArea.getSelectedText() + "</font>";
                    else if (fontSize.getSelectedItem() == "  Font Size 4")
                        FontS = "<font size=\"4\">" + txtArea.getSelectedText() + "</font>";
                    else if (fontSize.getSelectedItem() == "  Font Size 5")
                        FontS = "<font size=\"5\">" + txtArea.getSelectedText() + "</font>";
                    else if (fontSize.getSelectedItem() == "  Font Size 6")
                        FontS = "<font size=\"6\">" + txtArea.getSelectedText() + "</font>";
                    else
                        FontS = "<font size=\"7\">" + txtArea.getSelectedText() + "</font>";

                    txtArea.replaceSelection(FontS);
                }
            });


            //font Wizard

            final JComboBox fontWizard = new JComboBox(new String[]{"  Arial","  Tahoma","  Vani","  GulimChe"});
            fontWizard.setMinimumSize(new Dimension(60, 28));
            fontWizard.setBorder(emptyBorder);
            fontWizard.setToolTipText("Font Wizard ");
            fontWizard.setMaximumSize(new Dimension(60, 28));
            fontWizard.addActionListener(new ActionListener() {
                String Font = new String();
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (fontWizard.getSelectedItem()=="  Arial")
                        Font = "<span style=\"font-family: '@Arial Unicode MS'; font-weight: normal; font-style: normal; text-decoration: none;\">"+txtArea.getSelectedText()+"</span>";
                    else if (fontWizard.getSelectedItem()=="  Tahoma")
                        Font = "<span style=\"font-family: @Dotum, Tahoma, Tahoma; font-weight: normal; font-style: normal; text-decoration: none;\">"+txtArea.getSelectedText()+"</span>";

                    else if (fontWizard.getSelectedItem()=="  Vani")
                        Font = "<span style=\"font-family: '@Yu Gothic Light', Vani, Vani; font-weight: normal; font-style: normal; text-decoration: none;\">"+txtArea.getSelectedText()+"</span>";
                    else
                        Font = "<span style=\"font-family: '@Arial Unicode MS', @Gulim, @GulimChe; font-weight: normal; font-style: normal; text-decoration: none;\">"+txtArea.getSelectedText()+"</span>";

                    txtArea.replaceSelection(Font);
                }
            });

            //zoom
            JButton zoomIn = new JButton(zoomin);
            zoomIn.addActionListener(new ZoomINText());
            zoomIn.setBorder(emptyBorder);
            zoomIn.setToolTipText("Zoom In      Ctrl + P");

            JButton zoomOut = new JButton(zoomout);
            zoomOut.addActionListener(new ZoomOutText());
            zoomOut.setBorder(emptyBorder);
            zoomOut.setToolTipText("Zoom out      Ctrl + M");

            JButton Run = new JButton( Rune);
            Run.setIconTextGap(30);
            Run.setBounds(150, 150, 100, 25);
            Run.setBorder(emptyBorder);
            Run.setToolTipText("Run     Ctrl + R");
            Run.addActionListener(new RunBtn());

            addSeparator(new Dimension(10,0));
            add(New);
            add(open);
            add(save);
            add(saveAs);
            addSeparator(new Dimension(15, 37));
            add(Copy);
            add(Cut);
            add(Paste);
            addSeparator(new Dimension(15, 0));
            add(Undo);
            add(Redo);
            addSeparator(new Dimension(15, 0));
            add(Bold);
            add(Italic);
            add(Under);
            addSeparator(new Dimension(15, 0));
            add(alleft);
            add(alcenter);
            add(alright);
            add(aljustify);
            addSeparator(new Dimension(15, 0));
            add(fontWizard);
            addSeparator(new Dimension(5, 0));
            add(fontSize);
            addSeparator(new Dimension(15, 0));
            add(btnAddImage);
            add(btnAddLink);
            addSeparator(new Dimension(15, 0));
            add(zoomIn);
            add(zoomOut);
            addSeparator(new Dimension(400,0));
            addSeparator();
            add(Run);

        }
    }

//This Class Add an Image To the Html Code
    class AddImage extends JFrame {

        final JLabel Url = new JLabel(linkImage2);
        JLabel Title = new JLabel("Ttile:     ");
        final JComboBox Alignement = new JComboBox(new String[]{"left",
                "lenter", "right", "top", "middle", "bottom", "texttop", "baseline", "absbottom"});
        final JTextField imgTitle = new JTextField(38);
        final JTextField imgWidth = new JTextField(10);
        final JTextField imgHeight = new JTextField(10);
        //final JTextField img = new JTextField(10);
        final JTextArea imgUrl = new JTextArea(4, 38);
        final JButton loadImage = new JButton(desktop);
        public JTextField imgPath = new JTextField(38);
        final JButton generatCode = new JButton("Add");
        final JScrollPane imgUrlScroll = new JScrollPane(imgUrl);
        public JPanel pImg = new JPanel();

        JLabel widthLb = new JLabel("Width");
        JLabel heightLab = new JLabel("Height");
        JLabel imgAlLab = new JLabel("Allign");
        HtmlEdit caller;
        String filePath = new String();

        public AddImage(final HtmlEdit caller) {
                pImg.setLayout(null);
                this.caller = caller;
                imgUrl.setLineWrap(true);
                imgUrlScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

                loadImage.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        JFileChooser file = new JFileChooser(".");
                        FileFilter filter = new FileNameExtensionFilter("Image", "JPEG", "JPG", "GIF", "PNG");
                        file.addChoosableFileFilter(filter);
                        file.showOpenDialog(null);
                        File selected = file.getSelectedFile();
                        filePath = selected.getAbsolutePath();
                        imgPath.setText("file:///"+filePath);

                    }
                });


                generatCode.addActionListener(new ActionListener() {
                    public String Image = new String();

                    @Override

                    public void actionPerformed(ActionEvent e) {

                        //Image = "<img src=\""+imgUrl.getText()+"\" width=\""+imgWidth.getText()+"\" height=\""+imgHeight.getText()+"title=\""+imgTitle.getText()+  "\" align=\""+Alignement.getSelectedItem().toString()+"\" /></a>";
                        if (imgPath.getText() != null) {
                            System.out.print("vide");
                            Image = "<img  src=\"" + imgPath.getText()+imgUrl.getText();}

                        else
                        {System.out.print("ok");

                            Image = "<img  src=\"";}

                        if (imgWidth.getText() != null)
                            Image = Image + "\" width=\"" + imgWidth.getText();
                        else
                            Image = Image + "\" width=\"";

                        if (imgHeight.getText() != null)
                            Image = Image + "\" height=\"" + imgHeight.getText();
                        else
                            Image = Image + "\" height=\"";

                        if (imgTitle != null)
                            Image = Image + "\"title=\"" + imgTitle.getText() + "\" align=\"" + Alignement.getSelectedItem().toString() + "\" /></a>";

                        else
                            Image = Image + "title=\"" + "\" align=\"" + Alignement.getSelectedItem().toString() + "\" /></a>";


                        caller.insertToTextArea(Image);
                        setVisible(false);

                    }


                });


            Title.setBounds(20, 10, 100, 60);
            imgTitle.setBounds(60, 30, 400, 20);
            loadImage.setBounds(20, 60, 30, 30);
            imgPath.setBounds(60, 65, 400, 20);
            Url.setBounds(20, 100, 30, 30);
            imgUrlScroll.setBounds(60, 100, 400, 40);
            widthLb.setBounds(40, 140, 100, 60);
            imgWidth.setBounds(80, 160, 60, 20);
            heightLab.setBounds(170, 140, 100, 60);
            imgHeight.setBounds(220, 160, 60, 20);
            imgAlLab.setBounds(340, 140, 100, 60);
            Alignement.setBounds(390, 160,60,20);
            generatCode.setBounds(420, 200,60,20);

            pImg.add(Title);
            pImg.add(imgTitle);
            pImg.add(loadImage);
            pImg.add(imgPath);
            pImg.add(Url);
            pImg.add(imgUrlScroll);
            pImg.add(widthLb);
            pImg.add(imgWidth);
            pImg.add(heightLab);
            pImg.add(imgHeight);
            pImg.add(imgAlLab);
            pImg.add(Alignement);
            pImg.add(generatCode);

            add(pImg, BorderLayout.CENTER);

        }

    }

    // This Class Implements the Run Button Action
    private class RunBtn implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            labl.setText(txtArea.getText());
        }

    }

    //This Method Insert code to the Text Area
    public void insertToTextArea(String strImage) {
        txtArea.replaceSelection(strImage);
    }

//This Class extends the right mousse click
    class PopupListener extends MouseAdapter {
        JPopupMenu popup;

        PopupListener(JPopupMenu popupMenu) {
            popup = popupMenu;
        }

        public void mousePressed(MouseEvent e) {
            maybeShowPopup(e);
        }

        public void mouseReleased(MouseEvent e) {
            maybeShowPopup(e);
        }

        private void maybeShowPopup(MouseEvent e) {
            if (e.isPopupTrigger()) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    }

    // This Class Add a New Window
    class NewAction extends JFrame implements ActionListener{
        public NewAction(){

        }
        public void actionPerformed(ActionEvent e) {

            HtmlEdit html = new HtmlEdit();
            html.setTitle("Html Editor");
            html.setLocale(null);
            html.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            html.setVisible(true);
            html.pack();
        }
    }

    // This Class Close the Window
    class CloseAction extends WindowAdapter {
        public CloseAction(){}
        @Override
        public void windowClosing(WindowEvent we) {

            String ObjButtons[] = {"Save","Don't Save", "Cancel"};
            int PromptResult = JOptionPane.showOptionDialog(null,
                    "Do you want to save your project before close operation?", "Comfirm Exit !",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
                    ObjButtons, ObjButtons[2]);
            if (PromptResult == 1)
            if(PromptResult == 0) {

                String txtAreaContnet = txtArea.getText();
                File file = new File(filePath);

                if (file.isFile() && file.canRead()) {
                    try {

                        FileOutputStream fileOut = new FileOutputStream(filePath);
                        byte[] content = txtAreaContnet.getBytes();
                        fileOut.write(content);
                        fileOut.close();
                        dispose();

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                } else {
                    try {

                        FileDialog fDialogue = new FileDialog(new HtmlEdit(), "Save File As", FileDialog.SAVE);
                        fDialogue.setFile("untitled.html");
                        fDialogue.setVisible(true);
                        String path = fDialogue.getDirectory() + fDialogue.getFile();
                        filePath = fDialogue.getFile();
                        FileOutputStream fileOut = new FileOutputStream(path);
                        byte[] content = txtAreaContnet.getBytes();
                        fileOut.write(content);
                        fileOut.close();

                    } catch (Exception e) {
                        System.out.println(e);

                    }
                    if (filePath == null){
                        filePath = new String();
                    }
                    else {
                        System.exit(1);
                    }
                }
            }

        }
    }

    //This Class Create a Tree
    class Tree extends JTree{

        public Tree(){updateFiles();}

        public void updateFiles () {
            File fileRoot = new File("C:/Projects");
            DefaultMutableTreeNode root = new DefaultMutableTreeNode(fileRoot);
            DefaultTreeModel model = new DefaultTreeModel(root);

            File[] subItems = fileRoot.listFiles();
            for (File file : subItems) {
                root.add(new DefaultMutableTreeNode(file.getName()));
            }
            this.setModel(model);
        }

    }

    // This Is THE DEFAULT CONSTRACTOR
    public HtmlEdit (){

        createProjectFolder();

        this.addWindowListener(new CloseAction());

        Menu menu = new Menu();
        setJMenuBar(menu);

        ToolBar tlb = new ToolBar();
        tlb.setVisible(true);

        Tree tree = new Tree();

        ImageIcon img = new ImageIcon("images/icon.png");
        Image imgIcon = img.getImage();
        this.setIconImage(imgIcon);

        String htmlText = "<html> \n";

        txtArea = new JTextArea();
        txtArea.setText(htmlText);

        createPopupMenu();


        Line = new JTextArea("1     ");
        Line.setBackground(Color.CYAN);
        Line.setEditable(false);

        txtArea.getDocument().addDocumentListener(new DocumentListener(){
            public String getText(){
                int caretPosition = txtArea.getDocument().getLength();
                Element root = txtArea.getDocument().getDefaultRootElement();
                String text = "1     " + System.getProperty("line.separator");
                for(int i = 2; i < root.getElementIndex( caretPosition ) + 2; i++){
                    text += i + "     "+System.getProperty("line.separator");

                }
                return text;
            }
            @Override
            public void changedUpdate(DocumentEvent de) {
                Line.setText(getText()+"  ");
            }

            @Override
            public void insertUpdate(DocumentEvent de)  {
                Line.setText(getText()+"  ");
            }


            @Override
            public void removeUpdate(DocumentEvent de)  {
                Line.setText(getText()+"  ");
            }


        });

        Font font = new Font("Verdana", Font.HANGING_BASELINE, this.fontSize);
        txtArea.setFont(font);
        Line.setFont(font);


        JScrollPane scrll = new JScrollPane(txtArea);
        scrll.setRowHeaderView(Line);
        scrll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        labl = new JEditorPane("text/html",htmlText);

        final JPanel panlLeft = new JPanel();
        panlLeft.setLayout(new BorderLayout());
        panlLeft.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(
                        "   Write your HTML code and see the changes by one click...    "),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)));

        panlLeft.add(Box.createRigidArea(new Dimension(0,50)));
        panlLeft.setPreferredSize(new Dimension(840,1080));
        panlLeft.add(scrll);



        final JPanel panlRght = new JPanel();
        panlRght.setLayout(new FlowLayout(FlowLayout.CENTER));
        panlRght.setBackground(Color.WHITE);
        panlRght.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(
                        "    What You See Is What You Get   "),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        panlRght.add(Box.createRigidArea(new Dimension(11, 0)));
        panlRght.setPreferredSize(new Dimension(415,1080));
        panlRght.add(labl,BorderLayout.CENTER);


        JSplitPane splitH1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,tree,panlLeft);
        JSplitPane splitH2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,splitH1,panlRght);
        final JSplitPane splitV1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,tlb,splitH2);


        splitV1.setResizeWeight(0);
        splitH1.setDividerSize(9);
        splitH2.setDividerSize(3);
        splitV1.setDividerSize(3);

        add(splitV1, BorderLayout.CENTER);



        txtArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            public void undoableEditHappened(UndoableEditEvent e) {
                undoManager.addEdit(e.getEdit());
            }
        });}

    public void createPopupMenu() {
        JMenuItem Copy,Cut,Paste,Undo,Redo,Save,SaveAs,Select;

        //Create the popup menu.
        JPopupMenu popup = new JPopupMenu();
        Copy = new JMenuItem  ("Copy                      Ctrl + C",copy);
        Paste = new JMenuItem ("Paste                      Ctrl + V",Pastt);
        Cut = new JMenuItem   ("Cut                         Ctrl + X",Cutt);
        Undo = new JMenuItem  ("Undo                       Ctrl + Z",Und);
        Redo = new JMenuItem  ("Redo                       Ctrl + Y",Rdo);
        Save = new JMenuItem  ("Save                        Ctrl + S",Sv);
        SaveAs = new JMenuItem("Save As      Shift + Ctrl + S",SvAs);
        Select = new JMenuItem("Select                      Ctrl + A",select);

        Copy.addActionListener(new CopyAction());
        Cut.addActionListener(new CutAction());
        Paste.addActionListener(new PastAction());
        Save.addActionListener(new savingFile());
        SaveAs.addActionListener(new savingAS());
        Undo.addActionListener(new UndoAction());
        Redo.addActionListener(new RedoAction());
        Select.addActionListener(new SelectAction());

        popup.add(Copy);
        popup.add(Cut);
        popup.add(Paste);
        popup.add(new JSeparator());
        popup.add(Save);
        popup.add(SaveAs);
        popup.add(new JSeparator());
        popup.add(Undo);
        popup.add(Redo);
        popup.add(new JSeparator());
        popup.add(Select);

        //Add listener to the text area so the popup menu can come up.
        MouseListener popupListener = new PopupListener(popup);
        txtArea.addMouseListener(popupListener);
    }

    public void createProjectFolder() {
        //creating project folder
        File peojectsFolder = new File("C:/Projects");

        // if the directory does not exist, create it
        if (!peojectsFolder.exists()) {
            boolean result = false;

            try{
                peojectsFolder.mkdir();
                result = true;
            } catch(SecurityException se){

            }
            if(result) {
                System.out.println("folder exist");
            }
        }



    }

}
