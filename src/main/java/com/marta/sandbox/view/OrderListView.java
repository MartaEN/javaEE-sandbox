package com.marta.sandbox.view;

import com.marta.sandbox.dao.OrderDAO;
import com.marta.sandbox.entity.Order;
import com.marta.sandbox.enums.OrderStatus;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;
import java.util.List;

@Named
@RequestScoped
public class OrderListView extends AbstractView {

    @Inject
    private OrderDAO orderDAO;

    public List<Order> getOrders() { return orderDAO.getOrders(); }

    public List<OrderStatus> getStatuses() { return Arrays.asList(OrderStatus.values());  }

    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Status Edited", ((Order) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Order) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

}
