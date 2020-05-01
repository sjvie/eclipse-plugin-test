package de.sjvie.extension_point_test;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;

public class ResetHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IViewPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.findView(TestView.ID);
		if (part instanceof TestView) {
			TestView view = (TestView) part;
			view.reset();
		}
		return null;
	}
}
