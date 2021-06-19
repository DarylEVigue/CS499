using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Daryl_PL
{
    public partial class _Default : Page
    {
        localhost.Service1 myDatabaseAdapter = new localhost.Service1();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {

            }
        }

        protected void btnLogin_Click(object sender, EventArgs e)
        {
            String tmpStr = "";
            String tmpUserPassword = "";
            String tmpUserRecID = "";

            tmpUserPassword = myDatabaseAdapter.svcGetUserPassword(txtUserID.Text.Trim(), out tmpUserRecID);

            if (tmpUserPassword.Trim() == "" || tmpUserPassword.Trim() != txtPassword.Text.Trim())
            {
                tmpStr = "alert('You are not authorized to access this Web Site...');";
                this.Page.ClientScript.RegisterStartupScript(this.GetType(), "ex", tmpStr, true);
            }
            else
            {
                Response.Redirect("~/Contact.aspx?userRecID=" + tmpUserRecID);
            }
        }
    }
}