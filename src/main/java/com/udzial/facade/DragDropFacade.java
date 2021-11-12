package com.udzial.facade;

import com.udzial.pages.DragAndDropPage;
import com.udzial.pages.HomePage;

public class DragDropFacade {

    public DragDropFacade navigateToDragAndDropPage()
    {
        new HomePage().clickOnViewsSecondWay().clickAMenuItemWrapperWay("Drag and Drop");
        return this;
    }

    public DragAndDropPage getDragAndDropPage()
    {
        return new DragAndDropPage();
    }
}
