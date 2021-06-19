<%@ Page Title="Contact" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Contact.aspx.cs" Inherits="Daryl_PL.Contact" %>

<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">
    <h2>&nbsp;</h2>
    <h3>Your contact page.</h3>
    <address>
        &nbsp;</address>

    <table>
        <tr>
            <td>
                <asp:Label ID="lblFirstName" runat="server" Text="Label">First Name: </asp:Label>
            </td>
            <td>
                <asp:TextBox ID="txtFirstName" runat="server"></asp:TextBox>
            </td>
        </tr>
        <tr>
            <td>
                <br />
            </td>
        </tr>
        <tr>
            <td>
                <asp:Label ID="lblLastName" runat="server" Text="Label">Last Name: </asp:Label>
            </td>
            <td>
                <asp:TextBox ID="txtLastName" runat="server"></asp:TextBox>
            </td>
        </tr>
        <tr>
            <td>
                <br />
            </td>
        </tr>
        <tr>
            <td>
                <asp:Label ID="lblPhoneNumber" runat="server" Text="Label">Phone Number: </asp:Label>
            </td>
            <td>
                <asp:TextBox ID="txtPhoneNumber" runat="server"></asp:TextBox>
            </td>
        </tr>
    </table>
    <br />
    <br />
</asp:Content>
