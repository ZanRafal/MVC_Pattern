package view;

import controller.Controller;
import model.DataModel;

public interface View {
    void refesh(DataModel dataModel);

    void setController(Controller controller);
}
