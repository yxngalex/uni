﻿namespace CS322_DZ01
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.textBox2 = new System.Windows.Forms.TextBox();
            this.textBox3 = new System.Windows.Forms.TextBox();
            this.button1 = new System.Windows.Forms.Button();
            this.errorLab = new System.Windows.Forms.Label();
            this.button2 = new System.Windows.Forms.Button();
            this.color_red = new System.Windows.Forms.Button();
            this.color_green = new System.Windows.Forms.Button();
            this.hidden_label = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(210, 151);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(27, 15);
            this.label1.TabIndex = 0;
            this.label1.Text = "Ime";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(188, 175);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(49, 15);
            this.label2.TabIndex = 1;
            this.label2.Text = "Prezime";
            this.label2.Click += new System.EventHandler(this.label2_Click);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(194, 204);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(43, 15);
            this.label3.TabIndex = 2;
            this.label3.Text = "Adresa";
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(243, 143);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(287, 23);
            this.textBox1.TabIndex = 3;
            // 
            // textBox2
            // 
            this.textBox2.Location = new System.Drawing.Point(243, 172);
            this.textBox2.Name = "textBox2";
            this.textBox2.Size = new System.Drawing.Size(287, 23);
            this.textBox2.TabIndex = 4;
            // 
            // textBox3
            // 
            this.textBox3.Location = new System.Drawing.Point(243, 201);
            this.textBox3.Name = "textBox3";
            this.textBox3.Size = new System.Drawing.Size(287, 23);
            this.textBox3.TabIndex = 5;
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(455, 308);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 6;
            this.button1.Text = "Unesi";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // errorLab
            // 
            this.errorLab.AutoSize = true;
            this.errorLab.Location = new System.Drawing.Point(243, 239);
            this.errorLab.Name = "errorLab";
            this.errorLab.Size = new System.Drawing.Size(0, 15);
            this.errorLab.TabIndex = 7;
            this.errorLab.Click += new System.EventHandler(this.label4_Click);
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(426, 45);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(104, 33);
            this.button2.TabIndex = 8;
            this.button2.Text = "Hide Label";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // color_red
            // 
            this.color_red.Location = new System.Drawing.Point(455, 372);
            this.color_red.Name = "color_red";
            this.color_red.Size = new System.Drawing.Size(75, 23);
            this.color_red.TabIndex = 9;
            this.color_red.Text = "Red";
            this.color_red.UseVisualStyleBackColor = true;
            this.color_red.Click += new System.EventHandler(this.color_red_Click);
            // 
            // color_green
            // 
            this.color_green.Location = new System.Drawing.Point(363, 372);
            this.color_green.Name = "color_green";
            this.color_green.Size = new System.Drawing.Size(75, 23);
            this.color_green.TabIndex = 10;
            this.color_green.Text = "Green";
            this.color_green.UseVisualStyleBackColor = true;
            this.color_green.Click += new System.EventHandler(this.color_green_Click);
            // 
            // hidden_label
            // 
            this.hidden_label.AutoSize = true;
            this.hidden_label.Location = new System.Drawing.Point(262, 54);
            this.hidden_label.Name = "hidden_label";
            this.hidden_label.Size = new System.Drawing.Size(77, 15);
            this.hidden_label.TabIndex = 11;
            this.hidden_label.Text = "Lorem Ipsum";
            this.hidden_label.Click += new System.EventHandler(this.label4_Click_1);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.hidden_label);
            this.Controls.Add(this.color_green);
            this.Controls.Add(this.color_red);
            this.Controls.Add(this.button2);
            this.Controls.Add(this.errorLab);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.textBox3);
            this.Controls.Add(this.textBox2);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private Label label1;
        private Label label2;
        private Label label3;
        private TextBox textBox1;
        private TextBox textBox2;
        private TextBox textBox3;
        private Button button1;
        private Label errorLab;
        private Button button2;
        private Button color_red;
        private Button color_green;
        private Label hidden_label;
    }
}