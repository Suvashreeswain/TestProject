package com.demo.automation.framework.pagefactory;

import com.demo.automation.framework.TestSession;
import com.jcabi.aspects.Loggable;

/**
 *
 * @author Nimit Jain
 */
@Loggable
public class MobileWebViewPage extends Page {

    public MobileWebViewPage(TestSession session, String pageYamlFile) throws Exception {
        super(session, pageYamlFile);
    }

    @Override
    public Boolean isDisplayed() throws Exception {
        try {
            element(pageUI.expectedElements().get(0).name);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException(this.getClass().getName() + "does not have any expected elements defined in page spec");
        }
        return super.isDisplayed();
    }
}
