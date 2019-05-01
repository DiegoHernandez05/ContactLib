import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class PdfViewer extends JPanel {
    private static enum Navigation {
        GO_FIRST_PAGE, FORWARD, BACKWARD, GO_LAST_PAGE, GO_N_PAGE
    }
    private static final String GO_PAGE_TEMPLATE = "%s of %s";
    private static final int FIRST_PAGE = 1;
    private int currentPage = FIRST_PAGE;
    private JButton btnFirstPage;
    private JButton btnPreviousPage;
    private JTextField txtGoPage;
    private JButton btnNextPage;
    private JButton btnLastPage;
    private JButton print;
    private JButton search;
    String yes = "yes";
    public static List<String> contact = ContactLib.getArray();
    public PdfViewer() {
        initial();
    }

    private void initial() {
        setLayout(new BorderLayout(0, 0));
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(topPanel, BorderLayout.NORTH);
        btnFirstPage = createButton("|<<");
        topPanel.add(btnFirstPage);
        btnPreviousPage = createButton("<<");
        topPanel.add(btnPreviousPage);
        txtGoPage = new JTextField(10);
        txtGoPage.setHorizontalAlignment(JTextField.CENTER);
        topPanel.add(txtGoPage);
        btnNextPage = createButton(">>");
        topPanel.add(btnNextPage);
        btnLastPage = createButton(">>|");
        topPanel.add(btnLastPage);

        search = new JButton("search");
        topPanel.add(search);
        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.CENTER);
        JPanel viewPanel = new JPanel(new BorderLayout(0, 0));
        scrollPane.setViewportView(viewPanel);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // disableAllNavigationButton();

        search.addActionListener(new Action1());
    }

    private JButton createButton(String string) {
        return new JButton(string);
    }

    class Action1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog jDialog = new JDialog(SwingUtilities.getWindowAncestor(search));
            Label label = new Label("Search: ");
            final JTextField jTextField = new JTextField(10);
            jTextField.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Here perform search in PDF
                        int n = 0;
                        int y = 0;
                        System.out.println("Search for name " + jTextField.getText() + " requested");
                        System.out.println(contact);
                        for (String a : contact)
                        {
                            y++;
                        }
                        for (String b : contact)
                        {
                            
                            int z = b.indexOf(":");
                            int p = b.indexOf("phone");
                            String k = b.substring(z + 2, p - 9);
                            if (jTextField.getText().equals(k))
                            {
                                System.out.println("Here is what I found for the name " + k);
                                System.out.println(b);
                            }
                            else
                            {
                                n++;
                            }
                        }
                        if (n == y)
                        {
                            System.out.println("I found nothing in your contacts list with the name " + jTextField.getText());
                        }
                    }
                });
            // If you want to react to every change of text in the textfield, you can
            // use a DocumentListener and invoke the search method for all events.
            jTextField.getDocument().addDocumentListener(new DocumentListener() {

                    @Override
                    public void removeUpdate(DocumentEvent e) {

                    }

                    @Override
                    public void insertUpdate(DocumentEvent e) {

                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {

                    }
                });
            JPanel panel = new JPanel();
            jDialog.add(panel);
            panel.add(label);
            panel.add(jTextField);
            jDialog.pack();
            jDialog.setLocationRelativeTo(search);
            jDialog.setVisible(true);
        }
    }

    public static void main() {
        contact = ContactLib.getArray();
        SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JFrame frame = new JFrame();
                    frame.add(new PdfViewer());
                    frame.pack();
                    frame.setVisible(true);
                }
            });
    }
}