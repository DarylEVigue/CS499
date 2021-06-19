<%@ Page Title="Home Page" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="Daryl_PL._Default" %>

<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">

    <div class="jumbotron">
        <h1>ASP.NET</h1>
        <p class="lead">Daryl Vigue Project</p>
    </div>
    <br />
    <div class="row">
    <asp:Label ID="lblUserID" runat="server" Text="User ID:"></asp:Label>
    <asp:TextBox ID="txtUserID" runat="server"></asp:TextBox>
    <br />
    <br />
    <asp:Label ID="lblPassword" runat="server" Text="Password:"></asp:Label>
    <asp:TextBox ID="txtPassword" runat="server" TextMode="Password"></asp:TextBox>
    <br />
    <br />
    <asp:Button ID="btnLogin" runat="server" Text="Button" OnClick="btnLogin_Click" />
    </div>

</asp:Content>
