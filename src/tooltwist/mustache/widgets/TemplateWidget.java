package tooltwist.mustache.widgets;

import java.io.PrintWriter;

import tooltwist.wbd.CodeInserter;
import tooltwist.wbd.CodeInserterList;
import tooltwist.wbd.ContainerWidget;
import tooltwist.wbd.SnippetParam;
import tooltwist.wbd.JavascriptLinkInserter;
import tooltwist.wbd.WbdException;
import tooltwist.wbd.WbdGenerator;
import tooltwist.wbd.WbdGenerator.GenerationMode;
import tooltwist.wbd.WbdRenderHelper;
import tooltwist.wbd.WbdSizeInfo;
import tooltwist.wbd.WbdStringProperty;
import tooltwist.wbd.WbdWidget;
import com.dinaa.data.XNodes;
//import tooltwist.mustache.productionHelpers.TemplateProductionHelper;
import com.dinaa.ui.UimData;
import com.dinaa.ui.UimHelper;

/**
 * Mustache Template
 */
public class TemplateWidget extends ContainerWidget
{
	private static final String SNIPPET_PREVIEW = "template_preview.html";
//	private static final String SNIPPET_DESIGN = "template_design.html";
//	private static final String SNIPPET_PRODUCTION = "template_production.jsp";
	private static final boolean USE_PRODUCTION_HELPER = false;

	@Override
	protected void init(WbdWidget instance) throws WbdException
	{
		instance.defineProperty(new WbdStringProperty("elementId", null, "Id", ""));
//		instance.defineProperty(new WbdStringProperty("myProperty", null, "My Property", ""));
//		instance.defineProperty(new WbdNavPointProperty("navpoint", null, "Navpoint", ""));
	}
	
	@Override
	public void getCodeInserters(WbdGenerator generator, WbdWidget instance, UimData ud, CodeInserterList codeInserterList) throws WbdException
	{
//TODO: Uncomment this as required
		GenerationMode mode = generator.getMode();
		if (mode == GenerationMode.DESIGN)
		{
			// Add code inserters for design mode
			CodeInserter[] arr = {

//				// Include a CSS snippet
//				new StylesheetCodeInserter(instance.miscellaneousFilePath(generator, "template_cssHeader.css")),
			};
			codeInserterList.add(arr);
		}
		else if (mode == GenerationMode.PREVIEW)
		{
			// Add code inserters for preview mode
			CodeInserter[] arr = {
//				// Link to an external Javascript file
//				new JavascriptLinkInserter(jsUrl),

//				// Link to an external stylesheet
//				new StylesheetLinkInserter(cssUrl),

//				// Include a javascript snippet 
//				new JavascriptCodeInserter(instance.miscellaneousFilePath(generator, "template_jsHeader.js")),

//				// Include a CSS snippet
//				new StylesheetCodeInserter(instance.miscellaneousFilePath(generator, "template_cssHeader.css")),
			};
			codeInserterList.add(arr);
		}
		else if (mode == GenerationMode.PRODUCTION || generator.getMode() == GenerationMode.CONTROLLER)
		{

			// Add code inserters for production mode
			CodeInserter[] arr = {
				// Link to an external Javascript file
					new JavascriptLinkInserter("/ttsvr/mustache/mustache.min.js"),
					new JavascriptLinkInserter("/ttsvr/tooltwist/frameworks/jquery-1.7.1/jquery-1.7.1.min.js"),
					
//				// Link to an external stylesheet
//				new StylesheetLinkInserter(cssUrl),
					
//				// Include a javascript snippet 
//				new JavascriptCodeInserter(instance.miscellaneousFilePath(generator, "template_jsHeader.js")),
					
//				// Include a CSS snippet
//				new StylesheetCodeInserter(instance.miscellaneousFilePath(generator, "template_cssHeader.css")),

//				// Add import statements to the JSP
//				new PageImportCodeInserter(XData.class.getName()),
			};
			codeInserterList.add(arr);

			if (USE_PRODUCTION_HELPER)
			{
				SnippetParam[] productionHelperParams = null;
//				codeInserterList.add(WbdProductionHelper.codeInserter(instance, TemplateProductionHelper.class.getName(), productionHelperParams));
//				codeInserterList.add(new PageImportCodeInserter(TemplateProductionHelper.class.getName()));
			}
		}

	}
	
	@Override
	public String getLabel(WbdWidget instance) throws WbdException
	{
		return "template";
	}
	
	@Override
	public WbdSizeInfo getSizeInfo(WbdGenerator generator, WbdWidget instance) throws WbdException
	{
		return WbdSizeInfo.unknownSizeInfo();
	}
	
	@Override
	public void renderForPreview(WbdGenerator generator, WbdWidget instance, UimData ud, WbdRenderHelper rh) throws WbdException
	{
		rh.renderSnippetForStaticPage(generator, instance, SNIPPET_PREVIEW, getSnippetParams(generator, instance, ud));
	}
	
	@Override
	public void renderForDesigner(WbdGenerator generator, WbdWidget instance, UimData ud, WbdRenderHelper rh) throws WbdException
	{
//		rh.renderSnippetForStaticPage(generator, instance, SNIPPET_DESIGN, getSnippetParams(generator, instance, ud));
		rh.append("<div class=\"ttdesigner-mustache-template-div\">");
		
		// Display the children, starting with index 0.
		flowChildren_renderForDesigner(generator, instance, ud, rh, null);
		
		rh.append("</div>");
	}
	
	@Override
	public void renderForJSP(WbdGenerator generator, WbdWidget instance, UimHelper ud, WbdRenderHelper rh) throws Exception
	{
//		rh.beforeProductionCode(generator, instance, getSnippetParams(generator, instance, ud), USE_PRODUCTION_HELPER);
//		rh.renderSnippetForProduction(generator, instance, SNIPPET_PRODUCTION);
//		rh.afterProductionCode(generator, instance);
		String elementId = instance.getProperty("elementId", null);

		rh.append("<script id=\"" + elementId + "\" type=\"text/template\">");

//<h1>YEAH.<br>
//fname: {{firstName}}<br>
//surname:{{lastName}}</h1>
//Blog: {{blogURL}}

		flowChildren_renderForJSP(generator, instance, ud, rh, null);
		rh.append("</script>");

	}
	
	private SnippetParam[] getSnippetParams(WbdGenerator generator, WbdWidget instance, UimData ud) throws WbdException {
//		String myProperty = instance.getProperty("myProperty", null);
//		String myNavpoint = instance.getProperty("myNavpoint", null);
		SnippetParam[] params = {
//			new SnippetParam("myProperty", myProperty),
//			new SnippetParam("myNavpoint", myNavpoint)
		};
		return params;
	}
	
	@Override
	protected void loadPropertiesFromXml(WbdGenerator generator, WbdWidget widget, XNodes node) throws WbdException
	{
		// Read the properties of this widget
		super.loadPropertiesFromXml(generator, widget, node);

		// Get the child, if there is one.
		flowChildren_loadPropertiesFromXml(generator, widget, node, null);
	}

	@Override
	protected void writeProperties(WbdGenerator generator, WbdWidget instance, PrintWriter pw, int indent) throws WbdException
	{
		// Write the properties of this widget.
		instance.getProperties().writeProperties(pw, indent, null);
		
		// Save the children.
		flowChildren_writeProperties(generator, instance, pw, indent, null);
	}

}
