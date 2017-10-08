///*
//package com.example.android.secondcup;
//
//import android.widget.Toast;
//
//import com.example.android.secondcup.model.thread;
//import com.google.gson.Gson;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.Socket;
//public class Client extends thread
//{
//    Socket socket;
//    PrintWriter out;
//    BufferedReader read;
//    String ip;
//    public Client(String ip) throws IOException {
//        this.ip=ip;
//    }
//    @Override
//    public void run() {
//        super.run();
//        try
//        {
//            this.socket=new Socket(this.ip,8080);
//            out=new PrintWriter(socket.getOutputStream(),true);
//            read=new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            out.println(new Gson().toJson(Globals.getInstance().getOrder()));
//            out.flush();
//            out.close();
//            socket.close();
//            orderActivity.this.runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    Toast.makeText(orderActivity.this, "Order Sent", Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//            orderActivity.this.runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    Toast.makeText(orderActivity.this, "Server Not Connected", Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
//    }
//}
//*//*
//
//*/
///*
//
//public class Client extends AsyncTask<Void, Void, Void> {
//
//    String dstAddress;
//    int dstPort;
//    String response = "";
//    TextView textResponse;
//
//    Client(String addr, int port, TextView textResponse) {
//        dstAddress = addr;
//        dstPort = port;
//        this.textResponse = textResponse;
//    }
//
//    @Override
//    protected Void doInBackground(Void... arg0) {
//
//        Socket socket = null;
//
//        try {
//            socket = new Socket(dstAddress, dstPort);
//
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(
//                    1024);
//            byte[] buffer = new byte[1024];
//
//            int bytesRead;
//            InputStream inputStream = socket.getInputStream();
//
//			*//*
//*/
///*
//
//*//*
//
//*/
///*
//             * notice: inputStream.read() will block if no data return
//			 *//*
//*/
///*
//*//*
//
//*/
///*
//
//            while ((bytesRead = inputStream.read(buffer)) != -1) {
//                byteArrayOutputStream.write(buffer, 0, bytesRead);
//                response += byteArrayOutputStream.toString("UTF-8");
//            }
//
//        } catch (UnknownHostException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            response = "UnknownHostException: " + e.toString();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            response = "IOException: " + e.toString();
//        } finally {
//            if (socket != null) {
//                try {
//                    socket.close();
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }
//        }
//        return null;
//    }
//
//    @Override
//    protected void onPostExecute(Void result) {
//        textResponse.setText(response);
//        super.onPostExecute(result);
//    }
//
//}
//*//*
//*/
///*
//
//*/
