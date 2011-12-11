/*
 * DictionaryView.java
 */
package dictionary;

import dictionary.model.DictionaryModel;
import dictionary.model.Line;
import dictionary.model.TextModel;
import dictionary.model.Word;
import java.io.File;
import java.util.Iterator;
import org.jdesktop.application.Action;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 * The application's main frame.
 */
public class DictionaryView extends FrameView {

    DictionaryModel dm = null;
    TextModel tm = null;

    public DictionaryView(SingleFrameApplication app) {
        super(app);

        initComponents();

        // status bar initialization - message timeout, idle icon and busy animation, etc

    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = DictionaryApp.getApplication().getMainFrame();
            aboutBox = new DictionaryAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        DictionaryApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        loadDictionary = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dictionary = new javax.swing.JTextArea();
        loadText = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        result = new javax.swing.JTextArea();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();

        mainPanel.setName("mainPanel"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(dictionary.DictionaryApp.class).getContext().getActionMap(DictionaryView.class, this);
        loadDictionary.setAction(actionMap.get("choseDictionary")); // NOI18N
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(dictionary.DictionaryApp.class).getContext().getResourceMap(DictionaryView.class);
        loadDictionary.setText(resourceMap.getString("loadDictionary.text")); // NOI18N
        loadDictionary.setName("loadDictionary"); // NOI18N

        jScrollPane1.setFont(resourceMap.getFont("jScrollPane1.font")); // NOI18N
        jScrollPane1.setName("jScrollPane1"); // NOI18N

        dictionary.setColumns(20);
        dictionary.setFont(dictionary.getFont().deriveFont(dictionary.getFont().getSize()+3f));
        dictionary.setRows(5);
        dictionary.setName("dictionary"); // NOI18N
        jScrollPane1.setViewportView(dictionary);

        loadText.setAction(actionMap.get("choseText")); // NOI18N
        loadText.setText(resourceMap.getString("loadText.text")); // NOI18N
        loadText.setName("loadText"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        text.setColumns(20);
        text.setFont(text.getFont().deriveFont(text.getFont().getSize()+3f));
        text.setRows(5);
        text.setName("text"); // NOI18N
        jScrollPane2.setViewportView(text);

        jButton1.setAction(actionMap.get("findMistakes")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        result.setColumns(20);
        result.setFont(result.getFont().deriveFont(result.getFont().getSize()+3f));
        result.setRows(5);
        result.setName("result"); // NOI18N
        jScrollPane3.setViewportView(result);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loadDictionary)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loadText))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loadDictionary)
                    .addComponent(loadText)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setComponent(mainPanel);
        setMenuBar(menuBar);
    }// </editor-fold>//GEN-END:initComponents

    @Action
    public void choseDictionary() {
        dm = new DictionaryModel();
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Vyberte soubor slovníku");
        chooser.setDialogType(JFileChooser.OPEN_DIALOG);
        chooser.setMultiSelectionEnabled(false);
        int returnVal = chooser.showOpenDialog(DictionaryApp.getApplication().getMainFrame());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: "
                    + chooser.getSelectedFile().getName());
        }
        File f = chooser.getSelectedFile();
        dm.loadFile(f);
        dictionary.setText("");
        Iterator<Word> it = dm.getWords().iterator();
        while (it.hasNext()) {
            Word w = it.next();
            dictionary.setText(dictionary.getText() + w.getWord() + "\n");
        }
    }

    @Action
    public void choseText() {
        tm = new TextModel();
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Vyberte soubor slovníku");
        chooser.setDialogType(JFileChooser.OPEN_DIALOG);
        chooser.setMultiSelectionEnabled(false);
        int returnVal = chooser.showOpenDialog(DictionaryApp.getApplication().getMainFrame());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: "
                    + chooser.getSelectedFile().getName());
        }
        File f = chooser.getSelectedFile();
        tm.loadFile(f);
        text.setText(tm.toString());
    }

    @Action
    public void findMistakes() {
        if (dm != null && tm != null) {
            result.setText(tm.findMistakes(dm));
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea dictionary;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton loadDictionary;
    private javax.swing.JButton loadText;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTextArea result;
    private javax.swing.JTextArea text;
    // End of variables declaration//GEN-END:variables
    private JDialog aboutBox;
}
