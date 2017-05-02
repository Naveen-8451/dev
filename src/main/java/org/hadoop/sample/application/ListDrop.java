package org.hadoop.sample.application;

import java.awt.FlowLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;

public class ListDrop {

  class ListHandler extends TransferHandler {
    public boolean canImport(TransferSupport support) {
      if (!support.isDrop()) {
        return false;
      }

      return support.isDataFlavorSupported(DataFlavor.stringFlavor);
    }

    public boolean importData(TransferSupport support) {
      if (!canImport(support)) {
        return false;
      }

      Transferable transferable = support.getTransferable();
      String line;
      try {
        line = (String) transferable.getTransferData(DataFlavor.stringFlavor);
      } catch (Exception e) {
        return false;
      }
      JList.DropLocation dl = (JList.DropLocation) support.getDropLocation();
      int index = dl.getIndex();
      model.add(index++, line);
      return true;
    }
  }

  JTextField field = new JTextField(20);

  DefaultListModel model = new DefaultListModel();

  public ListDrop() {
    JFrame f = new JFrame();
    JList list = new JList(model);
    list.setDropMode(DropMode.INSERT);
    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    list.setTransferHandler(new ListHandler());

    field.setDragEnabled(true);
    f.setLayout(new FlowLayout());
    f.add(new JScrollPane(list));
    f.add(field);
    f.pack();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
  }

  public static void main(String[] args) {
    new ListDrop();
  }
}