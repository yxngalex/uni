<%@ Page Title="Home Page" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="Zadatak4._Default" %>

<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">

            <asp:TextBox ID="TextBox1" runat="server" CssClass="form-control"></asp:TextBox>
            <asp:Button ID="Button1" runat="server" Text="Submit" CssClass="btn btn-primary" OnClick="Unnamed2_Click"></asp:Button>
            <br />
            <br />
            <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
</asp:Content>
